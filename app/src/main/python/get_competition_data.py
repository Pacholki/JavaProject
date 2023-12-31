import soccerdata as sd
import os
import sys
from pathlib import Path

BASE_DIR = Path("src/main/resources/com/pacholki/data/leagues/")
CACHE_DIR = Path("src/main/resources/com/pacholki/cache/fbref/")

def teams(leagueID, season):

    league = leagueID[4:]
    LEAGUE_DIR = BASE_DIR / league
    LEAGUE_DIR = LEAGUE_DIR / season
    LEAGUE_DIR.mkdir(parents=True, exist_ok=True)
    

    fbref = sd.FBref(leagues=leagueID, seasons=season, data_dir = CACHE_DIR)
    schedule = fbref.read_schedule()

    file_name = "schedule.json"
    file_path = LEAGUE_DIR / file_name
    schedule_data = schedule.to_json(orient="records", lines=True).split("\n")
    
    with open (file_path, "w", encoding="utf-8") as file:
        file.write("[\n")
        game_number = 0
        schedule_size = len(schedule)

        for row in schedule_data:
            file.write("\t" + row)
            if game_number < schedule_size-1:
                file.write(",\n")
            game_number += 1
        file.write("\n]")


    teams = schedule.loc[leagueID, season, :]["home_team"].values
    teams = sorted(set([team.split('-')[0].strip() for team in teams]))

    file_name = "teams.json"
    file_path = LEAGUE_DIR / file_name
    with open (file_path, "w", encoding="utf-8") as file:

        file.write("[\n")
        team_number = 0
        league_size = len(teams)

        for team in teams:
            
            team_path = LEAGUE_DIR / team
            try:
                os.mkdir(team_path)
            except:
                pass
            
            file.write("\t{\"team\":\"" + team + "\"}")
            if team_number < league_size-1:
                file.write(",\n")
            team_number += 1
        file.write("\n]")

if __name__ == "__main__":
    try:
        leagueID = sys.argv[1]
        season = sys.argv[2]
    except:
        leagueID = "ENG-Premier League"
        season = "2223"

    teams(leagueID, season)
