# EMV CPLC

## Aplikacie:

### 1) **Credit Card Reader NFC (EMV) ** - Julien MILLEAU [Link](https://play.google.com/store/apps/details?id=com.github.devnied.emvnfccard)
  - Info: 
      - Log - vypis ADPU komunikacie 
      - Transactions - moznost vypisania transakcii
      - Card Type 
      - Pin try left
      - AID of card (Aplication Identifier)
      - Expire Date and Credit Card number
      - 
  - Povolenia 
      - NFC

### 2) **Pro Credit Card Reader NFC** - Julien MILLEAU (5,49€) [Link](https://play.google.com/store/apps/details?id=com.github.devnied.emvnfccard.pro)
  - Info
      - Rovnaké možnosti ako hore, len s možnosťou ukladať karty
  
  - Povolenia 
      - NFC

### 3) **Contactless Credit Card Reader** - MaxSoft Ltd [Link](https://play.google.com/store/apps/details?id=com.maxsoft.creditcardreader)
  -Info
      - Ukazuje základné informácie
          - Credit No
          - Expire Date
          - Card Description
      - Možnsosť upozornenia pri skončení platnosti karty

  - Povolenia 
      - Storage
      - Network Access - POTENTIALY DANGEROUS
      - NFC

### 4) **Credit Card Reader** - PS Technology [Link](https://play.google.com/store/apps/details?id=com.pstech.creditcardreaderapp)
  - Info
      -  Ukazuje informácie
          - Card Number
          - Valid Up To
          - Transactions
  - Povolenia
      - NFC

### ) **Credit Card NFC Reader - Antonov Andriy [Link](https://play.google.com/store/apps/details?id=com.pro100svitlo.nfccardread&hl=sk)
  - Info
      - Informacie 
          - Card Number
          - Valid Up To
      Showcase of Library [Link](https://github.com/pro100svitlo/Credit-Card-NFC-Reader)
      
  - Povolenia
      - NFC
   
### ) **NFC Smart Card Info** - Ino AppLLC [Link](https://play.google.com/store/apps/details?id=com.inoapp.cardinfo)
  - Info
      - show Tag ID
      - show Well Known Applications (Do not show custom applications)
          - known AIDs are in App 
  - Povolenia
      -NFC

### )  **NFC EMV Card Reader** - Viligan Vasilev (1.69€)  [Link](https://play.google.com/store/apps/details?id=com.pxdworks.nfcemvreader)
- Info
      - ??
  - Povolenia
      - ??

### ) **EMV Decoder** - VALDA [Link](https://play.google.com/store/apps/details?id=cz.valda.EMVDecoder)
- Info
      - ???
  - Povolenia
      - NFC

### **EMVContactlessReader** - Xavier Stenuit [Link](https://play.google.com/store/apps/details?id=com.development.ian.nfc_ian)
- BROKEN(spadlo mi to)
- 
  - Info
      - Select AID
      - Read App Data
      - Get Tags
  - Povolenia
      - NFC 

### ) **MX EMV Card Reader** - Microexpert [Link](https://play.google.com/store/apps/details?id=com.microexpert.www.mxemvreader)
  - Info:
      - Global Platform Version
      - Card Application Label
      - Card Application ID
      - Card Number
      - Card Valid From & Expiry Date
      - Card Transaction Counter
      - Card Track 2 Data (Chip copy of Magnetic stripe data)
  
  - Povolenia
      - 




## Github OpenSource:

### 1) **EMV-NFC-Paycard-Enrollment** \ Aplikace tiež (1, 2)
  - Licencia: Apache-2.0
      - Info: 
          - Log - vypis ADPU komunikacie 
          - Transactions - moznost vypisania transakcii
          - Card Type 
          - Pin try left
          - AID of card (Aplication Identifier)
          - Expire Date and Credit Card number
        
    - Linky: [GitHub](https://github.com/devnied/EMV-NFC-Paycard-Enrollment), [Google Store](https://play.google.com/store/apps/details?id=com.github.devnied.emvnfccard.pro)

### 2) **Library: Java EMV Reader**
  - Licencia: Apache-2.0
  - Info: Ta ista aplikacia ako 1) ,
  
  - Linky: [GitHub](https://github.com/devnied/EMV-NFC-Paycard-Enrollment), [Google Store](https://play.google.com/store/apps/details?id=com.github.devnied.emvnfccard.pro)

### 3) **Library: Java EMV Reader**
  - Licencia: Apache-2.0
  
  - linky: [GitHub](https://github.com/sasc999/javaemvreader)



## Postrehy
- niektore karty nemaju CPLC info


## Zaujimave casti kodu

- [ Typy kart podla (coho?)  (.txt)  |1](https://github.com/devnied/EMV-NFC-Paycard-Enrollment/blob/master/library/src/test/resources/smartcard_list.txt)
    - Info: rozne typy kariet ktore sa daju zistit z niecoho (pravdepodobne z CPLC)

- [Rozne sekvencie prikazov pre rozne karty](https://github.com/devnied/EMV-NFC-Paycard-Enrollment/tree/master/library/src/test/resources/data)
    - Dodatok:
        - pri kazdom sa opakuje na zacaitku zistenie CPLC info pomocov prikazu [80 CA 9F 7F 00] 
    - TODO - poriadne popozerat rozne prikazy, (skusit pochopit)

- [PSE, PPSE select strings](https://github.com/sasc999/javaemvreader/blob/f0d5920a94a0dc4be505fbb5dd03a7f1992f82bc/src/main/java/sasc/emv/EMVAPDUCommands.java#L53)

- [GlobalPlatform Docs](https://sourceforge.net/p/globalplatform/wiki/GPShell/)
    - Dodatok: 
        - pri vyhladani prikazu na vyber CPLC 80 CA 9F 7F 00 sa zobrazi struct odpovede

- [EMV Tags](https://github.com/sasc999/javaemvreader/blob/master/src/main/java/sasc/emv/EMVTags.java)
    -  Dodatok:
        - `//'9F50' to '9F7F' are reserved for the payment systems (proprietary)` - GOOD TO KNOW
        - riadok 181 : TAG pre zakladne info o karte
    
- [EMV ADPU Commands](https://github.com/sasc999/javaemvreader/blob/master/src/main/java/sasc/emv/EMVAPDUCommands.java#L26)

- [Nastroj na vyhladavanie EMV TAG](https://emvlab.org/emvtags/)

- [ Status Byte(SW) odpovede](https://github.com/sasc999/javaemvreader/blob/f0d5920a94a0dc4be505fbb5dd03a7f1992f82bc/src/main/java/sasc/emv/SW.java#L30)
    - Info: prehlad SW odpovedi

- [Bank Identiier Code(BIC)](https://github.com/sasc999/javaemvreader/blob/f0d5920a94a0dc4be505fbb5dd03a7f1992f82bc/src/main/java/sasc/emv/BankIdentifierCode.java#L24)
    - Info:  nejake zakladne info o BIC
    
- [VISA  Tags]( https://github.com/sasc999/javaemvreader/blob/master/src/main/java/sasc/emv/system/visa/VISATags.java)

- [MasterCard Tags]( https://github.com/sasc999/javaemvreader/blob/master/src/main/java/sasc/emv/system/mastercard) 
  - Dodatok : 
      - **!(VISA and MasterCard):  Iphone nemoze citat specialne Tagy**
## For begginers
- [Zoznam skratiek pre EMV](https://www.level2kernel.com/emv_glossary.html)

