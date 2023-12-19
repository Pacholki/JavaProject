import soccerdata as sd
import pandas as pd

# five38 = sd.FiveThirtyEight('ENG-Premier League', '2324')

epl = sd.FBref(leagues="ENG-Premier League", seasons=2023)

# print(epl.read_schedule())
match_lineup = epl.read_lineup(match_id="3a6836b4")

# for index, player_record in match_lineup.iterrows():
#     player_json = player_record.to_json()
#     print(player_json)

# for index, record in match_lineup.iterrows():
#     print(index)
#     print("dupawenża")
#     print(record)
#     break

file_path = "src/main/resources/match_lineup.json"

with open(file_path, "w") as file:
    file.write("[\n")
    row_count = len(match_lineup)
    current_row = 0
    for index, player_record in match_lineup.iterrows():
        player_json = player_record.to_json()
        file.write("\t")
        file.write(player_json)
        if current_row < row_count-1:
            file.write(",")
        file.write("\n")
        current_row += 1
    file.write("]")
