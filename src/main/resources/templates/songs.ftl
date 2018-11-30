<#import "./master.ftl" as com>
<@com.template>
<#list songs as item>
    <a href="/song/${item.code()}">${item.author} - ${item.title}</a>
<#else>
    No songs found
</#list>
</@com.template>