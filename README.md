## Layouts:

Aby poprawnie działały layouty potrzebujemy w `pom.xml` dodać zależność:

```xml
<dependency>
	<groupId>nz.net.ultraq.thymeleaf</groupId>
	<artifactId>thymeleaf-layout-dialect</artifactId>
</dependency>
```

W katalogu templates tworzymy główny plik szablonu np. `master.html` ze stosownym tagiem html
```html
<html xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
```

### dziedziczenie po layoucie w widoku

W widoku (np. `page.html`) ustawiamy stosowny tag html, wskazując w nim layout po którym chcemy dziedziczyć:

```html
<html xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" layout:decorate="~{layout/master.html}">
```

### layout:fragment

W dziedziczonym po layoucie widoku można nadpisać element używając layout:fragment np:

master.html
```html
<div layout:fragment="content"></div>
```

page.html
```html
<div layout:fragment="content">
    ...
</div>
```


### th:replace
th:replace podmieni na taga na innego, np:

master.html:
```html
<header th:replace="layout/header :: header"></header>
```

header.html:
```html
<header th:fragment="header">
    ...
</header>
```

Zapis `layout/header :: header` oznacza: z pliku widoku `layout/header.html` weź `th:element="header"`.