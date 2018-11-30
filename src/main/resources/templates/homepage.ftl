<#import "./master.ftl" as com>
<@com.template>
<form action="/song/search" method="get">
    <fieldset>
      <legend>QUICK FIND YOUR LYRICS</legend>
    </fieldset>
    <div class="inner-form">
      <div class="left">
        <div class="input-wrap second">
          <div class="input-field second">
            <label>CATEGORY</label>
            <div class="input-select">
              <select id="select-category" name="category">
                <#list categories as item>
                  <option value="${item}">${item}</option>
                </#list>
              </select>
            </div>
          </div>
        </div>
        <div class="input-wrap second">
          <div class="input-field second">
            <label>LANGUAGE</label>
            <div class="input-select">
              <select id="select-language" name="language">
                <#list languages as item>
                  <option value="${item}">${item}</option>
                </#list>
              </select>
            </div>
          </div>
        </div>
      </div>
      <button type="submit" id="button-search" class="btn-search">SEARCH</button>
    </div>
</form>
</@com.template>