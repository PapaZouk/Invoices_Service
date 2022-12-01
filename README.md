# Invoices_Service
Simple invoices service program made for workshops purpose. The main goal of this project is to implement simple invoice manager mechanism
which is divided into CEO (producer) and Accountant (consumer).

Program accept following commands:
- "CEO: ADD INVOICE(amount)" -> adding new invoice with specific amount to the stack
- "ACCOUNTANT: PROCESS INVOICE" -> processing first invoice on the stack
- "SHOW INVOICES" -> showing all avaible invoices
- "EIXT" -> exits program

Input example
---------------------
```
"CEO: ADD INVOICE(215.22)"
"SHOW INVOICES"
"ACCOUNTANT: PROCESS INVOICE"
"SHOW INVOICES"
```

Output example:
---------------------
```
CEO added invoice: ID: 1/2022, 215.22
Current invoices amount: 215.22. Current invoices to process: 
-------------------------------
[ID: 1/2022, amount: 215.22]

Current invoices to process: 
-------------------------------
[ID: 1/2022, amount: 215.22]

ACCOUNTANT processed invoice: {ID: 1/2022, AMOUNT: 215.22}
Current invoices amount: 0.00. Current invoices to process: 
-------------------------------

No more invoices to process
```


