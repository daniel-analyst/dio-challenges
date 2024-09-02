import os
import pyaes

def decrypt_file(encrypted_file_name, key, output_file_name):
    try:
        with open(encrypted_file_name, "rb") as file:
            encrypted_data = file.read()
    except FileNotFoundError:
        print("Erro: O arquivo " + encrypted_file_name " não encontrado.")
        return
    except IOError as e:
        print("Erro ao ler o arquivo " + encrypted_file_name)
        return

    aes = pyaes.AESModeOfOperationCTR(key)
    
    try:
        decrypted_data = aes.decrypt(encrypted_data)
    except Exception as e:
        print("Erro ao descriptografar os dados")
        return

    try:
        os.remove(encrypted_file_name)
    except OSError as e:
        print("Erro ao remover o arquivo " + encrypted_file_name)
        return

    try:
        with open(output_file_name, "wb") as file:
            file.write(decrypted_data)
    except IOError as e:
        print("Erro ao salvar o arquivo descriptografado " + output_file_name)


key = b"testeransomwares"
decrypt_file("teste.txt.ransomwaretroll", key, "teste.txt")