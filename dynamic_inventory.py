#!/usr/bin/env python3

import subprocess
import json

def get_inventory():
    terraform_output = subprocess.run(['terraform', 'output', '-json'], capture_output=True, text=True)
    output = json.loads(terraform_output.stdout)

    server_ip = output.get('server_ip', {}).get('value', '')

    if server_ip:
        inventory = {
            'all': {
                'hosts': [server_ip],
                'vars': {
                    'ansible_user': 'ubuntu',
                }
            }
        }
        return inventory
    else:
        return {}

if __name__ == '__main__':
    inventory = get_inventory()
    print(json.dumps(inventory))
