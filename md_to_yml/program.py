import re
import yaml

def extract_publications(markdown_file):
    with open(markdown_file, 'r') as file:
        content = file.read()

    publications = []
    publication_pattern = re.compile(
        r'• Tipo de produção: (.+) \((\d{4})\)\n'
        r'• Autor\(es\): (.+)\n'
        r'• Título do trabalho: (.+)\n'
        r'• Veículo de publicação com indicação de Qualis: (.+)\n'
        r'• Link DOI: (.+)\n'
    )
    # • Tipo de produção: (.+) \((\d{4})\)\n• Autor\(es\): (.+)\n• Título do trabalho: (.+)\n• Veículo de publicação com indicação de Qualis: (.+)\n• Link DOI: (.+)\n
    # print(publication_pattern.findall(content))

    for publication in publication_pattern.findall(content):
        p_type, year, authors, title, vehicle, doi = publication
        publications.append({
            'year': int(year), # Convert year to integer for sorting
            'type': p_type,
            'title': title,
            'authors': authors,
            'vehicle': vehicle,
            'doi': doi
        })

    # print(publications)

    return sorted(publications, key=lambda p: p['year'], reverse=True)


def write_to_yml(publications, yml_file):
    with open(yml_file, 'w') as file:
        yaml.dump(publications, file)

if __name__ == "__main__":
    markdown_file = "readfile.md"
    yml_file = "export.yml"
    publications = extract_publications(markdown_file)
    write_to_yml(publications, yml_file)