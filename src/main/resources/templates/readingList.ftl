<!DOCTYPE html>
<html>
<head>
    <title>Reading List</title>
    <link rel="stylesheet" href="/css/style.css"/>
</head>

<body>
<form action="/logout" method="POST">
    <input type="submit" value="Logout"/>
</form>
<h2>Your Reading List</h2>
<#if books?size != 0>
    <#list books as book>
        <dl>
            <dt class="bookHeadline">
                <span>${book.title}</span> by
                <span>${book.author}</span>
                (ISBN: <span>${book.isbn}</span>)
            </dt>
            <dd class="bookDescription">
                <#if book.description?length == 0>
                    <span>No description available</span>
                <#else>
                    <span>${book.description}</span>
                </#if>
            </dd>
        </dl>
    </#list>
<#else>
    <p>You have no books in your book list.</p>
</#if>

<hr/>

<h3>Add a book</h3>
<form action="/" method="POST">
    <label for="title">Title:</label>
    <input type="text" name="title" size="50"/><br/>
    <label for="author">Author:</label>
    <input type="text" name="author" size="50"/><br/>
    <label for="isbn">ISBN:</label>
    <input type="text" name="isbn" size="15"/><br/>
    <label for="description">Description:</label><br/>
    <textarea name="description" cols="80" rows="5"></textarea><br/>
    <input type="submit" value="Add Book"/>
</form>
</body>
</html>