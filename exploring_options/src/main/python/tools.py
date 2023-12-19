import soccerdata as sd
import os

league = "ENG-Premier League"
season = "2021"
team = "Manchester City"

def create_folder(folder_path):
    try:
        os.makedirs(folder_path)
    except OSError as e:
        print(f"Error creating folder '{folder_path}': {e}")

def get_team_games(league, season, team):

    fbref = sd.FBref(leagues=league, seasons=season)

    league_schedule = fbref.read_team_match_stats(stat_type="schedule", team=team)

    base_dir = "src/main/resources/"
    league_dir = base_dir + league + "/"
    season_dir = league_dir + season + "/"
    team_dir = season_dir + team + "/"

    create_folder(league_dir)
    create_folder(season_dir)
    create_folder(team_dir)

    file_path = team_dir + "games.json"
    with open (file_path, "w") as file:
        file.write("[\n")
        row_count = len(league_schedule)
        current_row = 0
        for index, game_record in league_schedule.iterrows():
            game_json = game_record.to_json()
            file.write("\t")
            file.write(game_json)
            if current_row < row_count-1:
                file.write(",")
            file.write("\n")
            current_row += 1
        file.write("]")

get_team_games(league, season, team)