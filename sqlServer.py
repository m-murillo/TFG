import pyodbc

#Informacion del server
server = 'LEFTO'
base_datos = 'tfg'

#Variables de la base de datos
id= 0
tipo= ''
ocasion= ''
color= ''
tejido= ''
ano= ''
precio= ''
marca= ''
tamano= ''
disenador= ''
caract_lavado= ''
temporada= ''
parte= ''
mangas= ''
largo= ''
estampado= ''
sugerencia_personal= ''
sugerencia_automatica= ''
temperatura= ''
foto= ''
notas= ''
puntuacion_general= ''
puntuacion_abrigo= ''

def recibir_nueva_prenda():
  #Recibirla
  print("Recibiendo...")

def mirar_prendas():
  #Mirarlas
  print("Mirando...")

def leer(conexion):
    print("Leyendo...")
    cursor = conexion.cursor()
    cursor.execute("select * from prenda")
    for row in cursor:
        print(row)

def crear(conexion):
    print("Creando...")
    cursor = conexion.cursor()
    #id += 1
    cursor.execute(
        'insert into prenda(id, tipo, ocasion, color,' + 
        'tejido, ano, precio, marca, tamano, disenador,' +
        'caract_lavado, temporada, parte, mangas, largo,' +
        'estampado, sugerencia_personal,' + 
        'sugerencia_automatica, temperatura, foto, notas,' + 
        'puntuacion_general, puntuacion_abrigo)' + 
        'values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)',
        (id, tipo, ocasion, color, tejido, ano, precio, 
        marca, tamano, disenador, caract_lavado, temporada, 
        parte, mangas, largo, estampado, sugerencia_personal,
        sugerencia_automatica, temperatura, foto, notas,
        puntuacion_general, puntuacion_abrigo)
    )
    conexion.commit()
    leer(conexion)

#ODBC Driver 17 for SQL Server
conexion = pyodbc.connect(
    'Driver={SQL Server Native Client 11.0}; \
     Server=lefto; \
     Database=tfg; \
     Trusted_Connection=yes;')

#for driver in pyodbc.drivers():
#    print(driver)

#diferentes funciones que sirvan como diferentes acciones o un programa para cada acción, o...
leer(conexion)
crear(conexion)

conexion.close()

#Redordatorio
#if mystring == "hello":
#    print("String: %s" % mystring)
#if isinstance(myfloat, float) and myfloat == 10.0:
#    print("Float: %f" % myfloat)
#if isinstance(myint, int) and myint == 20:
#    print("Integer: %d" % myint)