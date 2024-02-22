Vamos entender como os frameworks funciona, por baixo dos panos.

Sobre components JS:
Importante: quando for linkar a página JS com os components no HTML, você precisa adicionar o "defer", para que o navegador execute aquele script somente após o parse do documento, depois do navegdor criar sua DOM.
    ex. ```<script src="src/Components/Card.js" defer></script>```

Card.js:
```
    class Card extends HTMLElement {
        constructor () {
            super ();
        
            const shadow = this.attachShadow({ mode: "open"});
            shadow.innerHTML = "<h1>Hello!</h1>";
        }
    }

    customElements.define('card-news', Card);
```