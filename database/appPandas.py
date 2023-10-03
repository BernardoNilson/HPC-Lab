import pandas as pd

df = pd.read_excel("shop-products.xlsx")

# update the multiplier

df.loc[df["type"]=="service", "tax"] = 1.5

# update the final value

df["final value"] = df["tax"] * df["base price"]

df.to_excel("new-products.xlsx", index=False)

