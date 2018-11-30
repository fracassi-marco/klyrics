<#import "./master.ftl" as com>
<@com.template>
<div class="container">
    <div class="songlist">
        <h1>${song.author} - ${song.title}</h1>
        <p>${song.lyrics}</p>
    </div>
    <div class="buttons">
        <a href="/">Make another search!</a>
    </div>
</div>
</@com.template>