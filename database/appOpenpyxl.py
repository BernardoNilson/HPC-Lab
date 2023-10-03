from openpyxl import Workbook, load_workbook

df = load_workbook("shop-products.xlsx")

active = df.active

for celula in active["C"]: 
    if celula.value == "service":
        line = celula.row
        active[f"D{line}"] = 1.5

df.save("new-products-open.xlsx")
 