from datetime import datetime
pintCont = 1
menu = True;
saldo = 1000.0;
movement = []
movements = []
while (pintCont <= 3):
	 pin = int(input("PARA CONTINUAR INGRESA TU PIN DE 4 DIGITOS NUMERICOS\n"))
	 if (pin == 1234):
	 	break
	 pintCont += 1	
	 print("EL PIN ES INCORRECTO")

if (pintCont == 4):
	print("HAS EXCEDIDO EL NUMERO MAXIMO DE INTENTOS")
	menu = False;

while (menu):
	print("BIENVENIDO A NUESTRO SISTEMA")
	menuOption = int(input("INGRESA EL NUMERO DE LA OPCION ELEGIDA:\n1.CONSULTAR SALDO\n2.RETIRAR SALDO\n3.MOVIMIENTOS\n4.SALIR\n"))

	if (menuOption == 1):
		print("SU SALDO DISPONIBLE $",saldo)
		time = datetime.now().strftime('%d/%m/%Y %H:%M:%S')
		movement =["CONSULTA", time, saldo]
		movements.append(movement)
	elif (menuOption == 2):
		cantidad = float(input("INGRESE EL MONTO A RETIRAR\n"))
		if (cantidad < saldo):
			saldo -= cantidad;
			time = datetime.now().strftime('%d/%m/%Y %H:%M:%S')
			movement =["RETIRO", time, cantidad]
			movements.append(movement) 
			print("RETIRO EXITOSO")
		else:
			print("El MONTO EXCEDE EL SALDO DISPONIBLE $",saldo)	
	elif (menuOption == 3):
		print("HISTORIAL DE MOVIMIENTOS")
		print("TIPO\t\tFECHA Y HORA\t\tCANTIDAD")
		for item in movements:
			 print(item)

	elif (menuOption == 4):
		break

	exit = int(input("\n¿REGRESAR AL MENU?\n1.SI\n2.NO\n"))
	if (exit == 2):
	 	break
print("GRACIAS POR UTILIZAR NUESTRO SERVICIO")