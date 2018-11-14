<form action="/song/search" method="get">
<select id="select-category" name="category">
    <#list categories as item>
        <option value="${item}">${item}</option>
    </#list>
</select>
<select id="select-language" name="language">
    <#list languages as item>
        <option value="${item}">${item}</option>
    </#list>
</select>
<button type="submit" id="button-search">
</form>