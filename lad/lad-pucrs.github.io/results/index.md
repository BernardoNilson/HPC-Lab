---
layout: default
title: Produções científicas
category: results
---

<div class="card shadow-sm p-3">
    <div class="card-body">
    <h2 class="card-title fw-bold">{{ page.title }}</h2>
    {% include results_brief.html %}
    <ul>
        {% for production in site.data.production.export %}
        <p class="nav-item">
            {{ production.authors }}. <b>{{ production.title }}</b>. {{ production.vehicle }}. {{ production.year }}. Disponível em: <a class="link text-dark d-inline" href="{{ production.doi }}">{{ production.doi }}</a>
        </p>
        <br>
        {% endfor %} 
        </ul>
    </div>
</div>
