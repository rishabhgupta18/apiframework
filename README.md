# apiframework
<p>The fully customized API Framework for REST. The framework also customized the struts2 to meet business needs. <br/></p>

<p>
<b>Framework Flow</b>
<ul>When an endpoint is called - 
<li>struts2 validates whether the url is present in struts.xml file</li>
<li>The customized <b>RestActionMapper</b> will be called by struts, where before calling the method in the <b>Router</b>, we validate and handles business requirements </li>
<li>The call now goes to <b>Router</b> class and the method mentioned in the struts.xml file will be executed </li>
<li>In this method, we can call the Utils of a class and return the response. </li>
<li><b>addResponse</b> method converts the response to JSON</li>
</ul>
</p>
<br/>
<p>
<b>How to use it</b>
<ul>To use this framework, clone it to your local and follow the steps for each API endpoints - 
<li> Go to struts.xml file. </li>
<li> Copy and paste <b>action</b> tag in a new line </li>
<li><ul>The <b>action</b> tag contains following - 
  <li> name - the regex if for versioning purpose. Provide endpoint url after version regex</li>
    <li> class - The Framework defines the <b>Router</b> class, where every endpoint comes. The Router class routes to corrent Java class </li>
     <li> method - In <b>Router class, what method to invoke when this endpoint gets hit</b> </li>
    <li> param - additional info to know what the url contains like - /v1/ping means /version/feature  </li>
</ul></li>
<li> Go to <b>Router</b> class and add the method. The method name should match the criteria {HTTP METHOD}_{METHOD NAME PROVIDED IN struts.xml} </li>
<li> Create your API and call from this method</li>
<li> <b>addResponse</b> method will convert the response to JSON and send it to user</li>
</ul>
</p>
<p>
<b>Framework Flowt</b>
<ul> An endpoint called - 
<li>struts2 validates whether the url is present in struts.xml file</li>
<li>The customized <b>RestActionMapper</b> will be called by struts, where before calling the method in the <b>Router</b>, we validate and handles business requirements </li>
<li>The call now goes to <b>Router</b> class and the method mentioned in the struts.xml file will be executed </li>
<li>In this method, we can call the Utils of a class and return the response. </li>
<li><b>addResponse</b> method converts the response to JSON</li>
</ul>


</p>


<p>
<b>How to further customized it</b>
To customized further, 


</p>


