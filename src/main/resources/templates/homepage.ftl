<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="author" content="colorlib.com">
    <link href="https://fonts.googleapis.com/css?family=Poppins:400,500,700" rel="stylesheet" />
    <link href="assets/css/main.css" rel="stylesheet" />
  </head>
  <body>
    <div class="s013">
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
                  <select data-trigger="" id="select-category" name="category">
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
                  <select data-trigger="" id="select-language" name="language">
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
    </div>
    <script src="assets/js/choices.js"></script>
    <script>
      const choices = new Choices('[data-trigger]');
    </script>
</body>
</html>