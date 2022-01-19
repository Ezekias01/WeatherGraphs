
# PROGETTO WEATHER GRAPHS

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
Per iniziare, scaricare ed installare un opportuno ambiente di sviluppo Java come Intellij o Eclipse.
Una volta completata l’operazione sarà possibile, seguendo una serie di step, importare il progetto nel proprio ambiente di sviluppo.

PASSAGGI:
1) Copiare l’URL della repository GITHUB 
2) Aprire Eclipse e selezionare Import   Projects from Git (with smart import)
3) Utilizzare l’opzione CLONE URI nel Git import wizard e premere Next
4) Confermare l’URI, l’HOST e i parametri del percorso della Repository e premere Next
5) Scegliere il brench da clonare dalla repository remota e premere Next
6) Confermare la directory nella quale clonare la repository e premere Next
7) Scegliere il progetto da importare in Eclipse da Github premere Next

In questo modo l’importazione del progetto sarà completata e sarà possibile lanciare l’applicazione aprendo il main dell’Application e premendo Run as per poi selezionare “springboot application”.
Le varie rotte saranno utilizzabili tramite l’ausilio del http://localhost:8080/ al quale verranno aggiunti i filtri e i parametri che successivamente verranno illustrati.
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

#### Get JSON contenente la codifica delle date e delle fascie orarie

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

## Packages

### Chart 

#### Chart

![](https://github.com/Piz01/ProgettoEsame/blob/main/immagini_progetto/Chart.png?raw=true)

### Controller

#### ErrorePersonalizzato

![](https://github.com/Piz01/ProgettoEsame/blob/main/immagini_progetto/ErrorePersonalizzato.png?raw=true)

#### SimpleRestController

![](https://github.com/Piz01/ProgettoEsame/blob/main/immagini_progetto/SimpleRestController.png?raw=true)

### Exceptions

#### IllegalTimeSlotException

![](https://github.com/Piz01/ProgettoEsame/blob/main/immagini_progetto/IllegalTimeSlotException.png?raw=true)

#### NotFoundCityException

![](https://github.com/Piz01/ProgettoEsame/blob/main/immagini_progetto/NotFoundCityException.png?raw=true)

### Filter&Stats 

#### Filter

![](https://github.com/Piz01/ProgettoEsame/blob/main/immagini_progetto/Filter.png?raw=true)

#### FilterImpl

![](https://github.com/Piz01/ProgettoEsame/blob/main/immagini_progetto/FilterImpl.png?raw=true)

#### Stats

![](https://github.com/Piz01/ProgettoEsame/blob/main/immagini_progetto/Stats.png?raw=true)

#### StatsImpl

![](https://github.com/Piz01/ProgettoEsame/blob/main/immagini_progetto/StatsImpl.png?raw=true)

### Model

#### Citta

![](https://github.com/Piz01/ProgettoEsame/blob/main/immagini_progetto/ClasseCitta.png?raw=true)

#### Misura

![](https://github.com/Piz01/ProgettoEsame/blob/main/immagini_progetto/Misura.png?raw=true)

#### Punto

![](https://github.com/Piz01/ProgettoEsame/blob/main/immagini_progetto/Punto.png?raw=true)

#### Temperatura

![](https://github.com/Piz01/ProgettoEsame/blob/main/immagini_progetto/Temperatura.png?raw=true)

#### Weather

![](https://github.com/Piz01/ProgettoEsame/blob/main/immagini_progetto/Weather.png?raw=true)

### Service

#### Gestore

![](https://github.com/Piz01/ProgettoEsame/blob/main/immagini_progetto/Gestore.png?raw=true)

#### GestoreImpl

![](https://github.com/Piz01/ProgettoEsame/blob/main/immagini_progetto/GestoreImpl.png?raw=true)

## Strumenti utilizzati
- Eclipse
- Springboot
## Autori
- Ezekias Mastaki
- Andrea Pizzuto
