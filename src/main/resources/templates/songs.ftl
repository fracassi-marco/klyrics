<#list songs as item>
    <a href="/song/${item.title}">${item.author} - ${item.title}</a>
<#else>
    No songs found
</#list>