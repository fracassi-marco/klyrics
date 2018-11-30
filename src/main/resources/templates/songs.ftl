<#import "./master.ftl" as com>
<@com.template>
<div class="container">
    <div class="songlist">
    <#list songs as item>
        <a href="/song/${item.code()}">${item.author} - ${item.title}</a>
    <#else>
        <p>No songs found</p>
    </#list>
    </div>
    <div class="buttons">
        <a href="/">Make another search!</a>
    </div>
</div>
</@com.template>