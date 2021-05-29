import json
import requests
import os.path as path

api_url_base = 'https://www.easports.com/fifa/ultimate-team/api/fut/'
headers = {'Content-Type': 'application/json'}
sql_file = "script.sql"

set_base_id = set()

if path.exists(sql_file):
    exit()

f = open(sql_file, "a", encoding='utf-8')

def get_account_info(page):
    api_url = '{0}item?page={1}'.format(api_url_base, page)

    response = requests.get(api_url, headers=headers)

    if response.status_code == 200:
        return json.loads(response.content.decode('utf-8'))
    else:
        return None


def proccess_players(page):
    response = get_account_info(page)['items']
    for player in response:
        # Avoid repeat players
        if not (player['baseId'] in set_base_id or set_base_id.add(player['baseId'])):
            write_insert_player(player)


def write_insert_player(player):
    name = player['name'].replace("'", "''")
    position = player['position'].replace("'", "''")
    nation = player['nation']['name'].replace("'", "''")
    club = player['club']['name'].replace("'", "''")
    insert = f"INSERT INTO players (name, position, nation, team)" \
             f" VALUES ('{name}', '{position}', '{nation}', '{club}');\n"
    f.write(insert)


for i in range(1, 910):
    print(f'page: {i}')
    proccess_players(i)

f.close()