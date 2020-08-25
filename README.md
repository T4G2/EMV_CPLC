# EMV CPLC

## Aplications:

### 1) **Credit Card Reader NFC (EMV) ** - Julien MILLEAU [Link](https://play.google.com/store/apps/details?id=com.github.devnied.emvnfccard)
  - Info: 
      - Log of ADPU communication
      - Transactions - able to show latest transactions
      - Card Type 
      - Pin try left
      - AID of card (Aplication Identifier)
      - Expire Date and Credit Card number
      - 
  - Permissions
      - NFC

### 2) **Pro Credit Card Reader NFC** - Julien MILLEAU (5,49€) [Link](https://play.google.com/store/apps/details?id=com.github.devnied.emvnfccard.pro)
  - Info
      - Same as above, but able to save cards

  - Permissions
      - NFC

### 3) **Contactless Credit Card Reader** - MaxSoft Ltd [Link](https://play.google.com/store/apps/details?id=com.maxsoft.creditcardreader)
  -Info
   - Show basic info:
        - Credit No
        - Expire Date
        - Card Description
              - able to turn on notification when card expires

  - Permissions
      - Storage
      - Network Access - POTENTIALY DANGEROUS
      - NFC

### 4) **Credit Card Reader** - PS Technology [Link](https://play.google.com/store/apps/details?id=com.pstech.creditcardreaderapp)
  - Info
      -  Show basic info:
          - Card Number
          - Valid Up To
          - Transactions
  - Permissions
      - NFC

### 5) **Credit Card NFC Reader - Antonov Andriy [Link](https://play.google.com/store/apps/details?id=com.pro100svitlo.nfccardread&hl=sk)
  - Info
      - Informacie 
          - Card Number
          - Valid Up To
      Showcase of Library [Link](https://github.com/pro100svitlo/Credit-Card-NFC-Reader)
      
  - Permissions
      - NFC

### 6) **NFC Smart Card Info** - Ino AppLLC [Link](https://play.google.com/store/apps/details?id=com.inoapp.cardinfo)
  - Info
      - show Tag ID
      - show Well Known Applications (Do not show custom applications)
          - known AIDs are in App 
  - Permissions
      -NFC

### 7)  **NFC EMV Card Reader** - Viligan Vasilev (1.69€)  [Link](https://play.google.com/store/apps/details?id=com.pxdworks.nfcemvreader)
- Info
      - ??
  - Permisions
      - NFC

### 8) **EMV Decoder** - VALDA [Link](https://play.google.com/store/apps/details?id=cz.valda.EMVDecoder)
- Info
  
      - ???
  
  - Permissions
      - NFC

### **9)EMVContactlessReader** - Xavier Stenuit [Link](https://play.google.com/store/apps/details?id=com.development.ian.nfc_ian)
- BROKEN(on my phone)
- 
  - Info
      - Select AID
      - Read App Data
      - Get Tags
  - ermisions
      - NFC 

### 10) **MX EMV Card Reader** - Microexpert [Link](https://play.google.com/store/apps/details?id=com.microexpert.www.mxemvreader)
  - Info:
      - Global Platform Version
      - Card Application Label
      - Card Application ID
      - Card Number
      - Card Valid From & Expiry Date
      - Card Transaction Counter
      - Card Track 2 Data (Chip copy of Magnetic stripe data)
  
  - Permisions
      - NFC




## Github OpenSource:

### 1) **EMV-NFC-Paycard-Enrollment** \ Application number (1, 2)
  - Licence: Apache-2.0
      - Info: 
          - Log - vypis ADPU komunikacie 
          - Transactions - moznost vypisania transakcii
          - Card Type 
          - Pin try left
          - AID of card (Aplication Identifier)
          - Expire Date and Credit Card number
        
    - Links: [GitHub](https://github.com/devnied/EMV-NFC-Paycard-Enrollment), [Google Store](https://play.google.com/store/apps/details?id=com.github.devnied.emvnfccard.pro)

### 2) **Library: Java EMV Reader**
  - Licence: Apache-2.0
  - Links: [GitHub](https://github.com/sasc999/javaemvreader)

### 2.1) ** Application based on 2) **
  - Links [GitHub](https://github.com/JackuyLiu/Android-NFC-Paycard-Reader)

### 3) **Library: Credit-Card-NFC-Reader**
  - Licence:  MIT
  - Links: [GitHub](https://github.com/pro100svitlo/Credit-Card-NFC-Reader)

### 4) **Application: NFC-EMV-Reader  **
  - Licence: GPL 3.0
  - Links [GitHub] (https://github.com/n37sn4k3/NFC-EMV-Reader) 



## Observations
- Some cards dfo not have CPLC info

## Interesting parts of code

- [Card Types o(.txt)  |1](https://github.com/devnied/EMV-NFC-Paycard-Enrollment/blob/master/library/src/test/resources/smartcard_list.txt)
    - Info: different cards can be detected out of something (Applet ID or something from CPLC)

- [Sequences of Commands for diferent types of cards](https://github.com/devnied/EMV-NFC-Paycard-Enrollment/tree/master/library/src/test/resources/data)
    - More Info:
        - on start of every sequence there is ADPU get CPLC [80 Ca 9F 7F 00]
    - TODO -look at all commands, try to understand

- [PSE, PPSE select strings](https://github.com/sasc999/javaemvreader/blob/f0d5920a94a0dc4be505fbb5dd03a7f1992f82bc/src/main/java/sasc/emv/EMVAPDUCommands.java#L53)

- [GlobalPlatform Docs](https://sourceforge.net/p/globalplatform/wiki/GPShell/)
    - add. : 
        - when sending ADPU command CPLC 80 CA 9F 7F 00, the CPLC will be recieved

- [EMV Tags](https://github.com/sasc999/javaemvreader/blob/master/src/main/java/sasc/emv/EMVTags.java)
    -  add. :
        - `//'9F50' to '9F7F' are reserved for the payment systems (proprietary)` - Good to Know
        - row 181 : TAG to get basic info about card
    
- [EMV ADPU Commands](https://github.com/sasc999/javaemvreader/blob/master/src/main/java/sasc/emv/EMVAPDUCommands.java#L26)

- [Searching tool of EMV TAGS](https://emvlab.org/emvtags/)

- [ Status Byte(SW) responses](https://github.com/sasc999/javaemvreader/blob/f0d5920a94a0dc4be505fbb5dd03a7f1992f82bc/src/main/java/sasc/emv/SW.java#L30)
    - Info: rewien of SW responses

- [Bank Identiier Code(BIC)](https://github.com/sasc999/javaemvreader/blob/f0d5920a94a0dc4be505fbb5dd03a7f1992f82bc/src/main/java/sasc/emv/BankIdentifierCode.java#L24)
    - Info:  basic info about  BIC
    
- [VISA  Tags]( https://github.com/sasc999/javaemvreader/blob/master/src/main/java/sasc/emv/system/visa/VISATags.java)

- [MasterCard Tags]( https://github.com/sasc999/javaemvreader/blob/master/src/main/java/sasc/emv/system/mastercard) 
  - add. : 
      - **!(VISA and MasterCard):  Iphone can't read special Tags**
## For begginers
- [Abreviations of EMV](https://www.level2kernel.com/emv_glossary.html)

