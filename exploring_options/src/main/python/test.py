import soccerdata as sd

fbref = sd.FBref(leagues="ENG-Premier League", seasons=["2122"])

league_schedule = fbref.read_team_match_stats(stat_type="schedule", team="Manchester City")

# for index, game in league_schedule.iterrows():
#     game_json = game.to_json()
#     print(game_json)

file_path = "src/main/resources/league_schedule.json"
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
