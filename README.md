
## PROGETTO WEATHER GRAPHS

Il progetto Weather Graphs si propone di fornire uno strumento mediante il quale,
date delle città, eseguire delle statistiche riguardanti una serie di parametri metereologici
al fine di produrre dei grafici utili per interpretare i risultati ottenuti. 
I suddetti parametri metereologici sono: 
- temperatura effettiva
- temperatura percepita
- temperatura massima
- temperatura minima
- umidità
Le statistiche sono state eseguite attenendosi ad un preciso criterio di filtraggio e sono le seguenti:
- media 
- varianza
- deviazione standard
## Indice
- Let's start
- Endpoints
- Filtri disponibili
- Api calls
- Uml
- Packages
    - Chart 
    - Controller
    - Exceptions
    - Filter&Stats 
    - Model
    - Service
- Strumenti utilizzati
- Autori
## Let's start
Dopo aver scaricato un opportuno ambiente di sviluppo java (ad esempio intellij o eclipse) per la 
visualizzazione del codice è possibile clonare la repository GitHub
(attraverso il comando "clone a repository", situato nella show view della
finestra Git Repositories). Ora è possibile importare il progetto attraverso il comando 
"Import Project" che compare cliccando con tasto destro sulla repository clonata,
nella finestra a comparsa. Quando il programma è pronto, è possibile eseguirlo cliccando 
con tasto destro sul progetto importato(situato nel Package Explorer).
Infine nella finestra a comparsa si troverà il comando "Run as", eseguire quindi il programma 
come "Spring boot App".
Ora l'applicazione Web Service sarà attiva e in ascolto alla porta http://localhost:8080.
## Endpoints
| Tipo | Rotta     | Descrizione                |
| :-------- | :------- | :------------------------- |
| `GET` | `/citta` | `restituisce l'elenco dei nomi delle citta prestabilite`  |
| `GET` | `/index` | `restituisce un JSON contente la codifica delle date e delle fascie orarie ` |
| `GET` | `/metadata/measurements` | `restituisce una lista di misure filtrate sulle base dei parametri inseriti dall'utente` |
| `GET` | `/stats/{filter}` | `restituisce dei grafici a seconda del filtro scelto` |
| `GET` | `/error` | `restituisce un errore generale` |

## Filtri disponibili

| Nome Filter | Descrizione | 
| :------- | :------------------------- |
| `mediumTemperature` | `restituisce un grafico a barre contenente il confronto delle medie delle temperature effettive`  |
| `humidityVariance` | `restituisce un un grafico a barre contenente il confronto delle varianze delle umidita'` |
| `MaxComparison` | `restituisce un grafico a linee contenente il confronto delle temperature massime` |

## API Calls

#### Get elenco dei nomi delle citta prestabilite

```http
  GET localhost:8080/citta
```


![](https://github.com/Piz01/ProgettoEsame/blob/main/immagini_progetto/Citta.PNG?raw=true)

#### Get JSON contente la codifica delle date e delle fascie orarie

```http
  GET localhost:8080/index
```
```json
[
    {"days": 
        [
            {      "id": 1, 
                    "name": "Giovedi"
            },
            {      "id": 2,
                "name": "Venerdi"
            },
            {      "id": 3,
                "name": "Sabato"
            },
            {      "id": 4,      
                "name": "Domenica"
            }
        ]
    },
    {"timeslots": 
        [
            {      "id": 1,
                  "description": "6-9"
            },
            {      "id": 2,
                   "description": "12-15"
            },
            {      "id": 3,      
                   "description": "18-21"
            }
        ]
    }
]
```

#### Get lista di misure filtrate sulle base dei parametri inseriti

```http
  GET localhost:8080/metadata/measurements?CityName={CityName}&FirstDay={FirstDayCode}&LastDay={LastDayCode}&TimeSlot={TimeSlotCode}
```
| Parametri   | 
| :---------------------------------|
| `CityName` _required_ `nome della città`  |
| `FirstDay` _required_  `codice del primo giorno` |
| `LastDay` _required_  `codice dell'ultimo giorno` |
| `TimeSlot` _required_  `codice della fascia oraria` |


#### Get grafico a barre che confronta le temperature medie di due città

```http
  GET localhost:8080/stats/mediumTemperature?firstCityName={firstCityName}&secondCityName={secondCityName}&FirstDay={FirstDayCode}&LastDay={LastDayCode}&TimeSlot={TimeSlotCode}
```
| Parametri   | 
| :---------------------------------|
| `FirstCityName` _required_ `nome della prima città`  |
| `SecondCityName` _required_ `nome della seconda città`  |
| `FirstDay` _required_  `codice del primo giorno` |
| `LastDay` _required_  `codice dell'ultimo giorno` |
| `TimeSlot` _required_  `codice della fascia oraria` |

![](https://github.com/Piz01/ProgettoEsame/blob/main/immagini_progetto/mediumTemperature.PNG?raw=true)

#### Get grafico a barre che confronta le varianze di tutte le citta prestabilite

```http
  GET localhost:8080/stats/humidityVariance?firstCityName={firstCityName}&secondCityName={secondCityName}&FirstDay={FirstDayCode}&LastDay={LastDayCode}&TimeSlot={TimeSlotCode}
```
| Parametri   | 
| :---------------------------------|
| `FirstCityName` _required_ `nome della prima città`  |
| `SecondCityName` _required_ `nome della seconda città`  |
| `FirstDay` _required_  `codice del primo giorno` |
| `LastDay` _required_  `codice dell'ultimo giorno` |
| `TimeSlot` _required_  `codice della fascia oraria` |

![](https://github.com/Piz01/ProgettoEsame/blob/main/immagini_progetto/humidityVariance.PNG?raw=true)

#### Get grafico a linee che confronta le temperature di tutte le citta prestabilite
```http
  GET localhost:8080/stats/MaxComparison?FirstDay={FirstDayCode}&LastDay={LastDayCode}&TimeSlot={TimeSlotCode}
```
| Parametri   | 
| :---------------------------------|
| `FirstDay` _required_  `codice del primo giorno` |
| `LastDay` _required_  `codice dell'ultimo giorno` |
| `TimeSlot` _required_  `codice della fascia oraria` |

![](https://github.com/Piz01/ProgettoEsame/blob/main/immagini_progetto/MaxComparison.PNG?raw=true)

#### Get errore generale

```http
  GET localhost:8080/error
```
![This is an image](https://github.com/Piz01/ProgettoEsame/blob/main/immagini_progetto/error.PNG?raw=true)

## Uml
## Packages
## Strumenti utilizzati
- Eclipse
- Springboot
-
## Autori
- Ezekias Mastaki
- Andrea Pizzuto
