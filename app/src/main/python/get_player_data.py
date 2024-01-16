import soccerdata as sd
import sys
from pathlib import Path
import json

BASE_DIR = Path("src/main/resources/com/pacholki/data/leagues/")
CACHE_DIR = Path("src/main/resources/com/pacholki/cache/fbref/")
def players(leagueID, season):

    league = leagueID[4:]
    LEAGUE_DIR = BASE_DIR / league
    LEAGUE_DIR = LEAGUE_DIR / season
    LEAGUE_DIR.mkdir(parents=True, exist_ok=True)

    fbref = sd.FBref(leagues=leagueID, seasons=season, data_dir=CACHE_DIR)
    players_data = fbref.read_player_season_stats()

    file_name = "players.json"
    file_path = LEAGUE_DIR / file_name

    players_data = players_data.reset_index()

    players_data = players_data.fillna(0.0)

    with open(file_path, "w", encoding="utf-8") as file:
        file.write("[\n")
        record_number = 0
        record_count = len(players_data)

        for _, row in players_data.iterrows():
            merged_columns = {f"{col[0]}{col[1]}": row[col] for col in players_data.columns}

            json_string = json.dumps(merged_columns, ensure_ascii=False, default=str)

            file.write("\t" + json_string)
            if record_number < record_count - 1:
                file.write(",\n")
            record_number += 1
        file.write("\n]")

if __name__ == "__main__":
    try:
        leagueID = sys.argv[1]
        season = sys.argv[2]
    except:
        leagueID = "ENG-Premier League"
        season = "2324"

    players(leagueID, season)