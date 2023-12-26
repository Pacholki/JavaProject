import soccerdata as sd
import os

BASE_DIR = "src/main/resources/data/"
leagueID="ENG-Premier League"
season="2122"



def teams(leagueID, season):

    fbref = sd.FBref(leagues=leagueID, seasons=season)
    schedule = fbref.read_schedule()

    teams = schedule.loc[leagueID, season, :]["home_team"].values
    teams = sorted(set([team.split('-')[0].strip() for team in teams]))

    league = leagueID[4:]
    league_path = BASE_DIR + league + season + "/"
    
    try:
        os.makedirs(league_path)
    except:
        pass

    file_name = "teams"
    file_path = league_path + file_name
    with open (file_path, "w") as file:

        file.write("[\n")
        team_number = 0
        league_size = len(teams)

        for team in teams:
            file.write("\t{\"team\":\"" + team + "\"}")
            if team_number < league_size-1:
                file.write(",\n")
            team_number += 1
        file.write("\n]")