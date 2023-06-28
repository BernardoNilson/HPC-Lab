# Import packages
# We import the dcc module (DCC stands for Dash Core Components).
# This module includes a Graph component called dcc.Graph, which is used to render interactive graphs.
from dash import Dash, html, dash_table, dcc
# Pandas is used to read the sheets, xlsm, CSL, etc
import pandas as pd
# Plotly is used to visualize all the information requested. It is like a constructor of interactive graphs
import plotly.express as px

# Incorporate data, just a Dash example
# If I want to put a archive, I use: 
# in the same folder that contains the app.py file. Then, update the line of code to: df = pd.read_csv('NameOfYourFile.csv')
df = pd.read_csv('https://raw.githubusercontent.com/plotly/datasets/master/gapminder2007.csv')

# Initialize the app
app = Dash(__name__)

# App layout
app.layout = html.Div([
    html.Div(children='My First App with Data and a Graph'),
    dash_table.DataTable(data=df.to_dict('records'), page_size=10),
    dcc.Graph(figure=px.histogram(df, x='continent', y='lifeExp', histfunc='avg'))
])

# Run the app
if __name__ == '__main__':
    app.run(debug=True)
