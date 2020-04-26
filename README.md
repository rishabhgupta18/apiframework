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
<b>How to further customized it</b>
To customized further - 
<ul>
  <li>To add additional business needs before the call goes to Router, <b>RestActionMapper</b> can be customized. The RestActionMapper is already customized to meet this business need - 
    <ul>
      <li>for any method in struts.xml, the Router class should contain {HTTP METHOD}_{METHOD NAME}</li>
      <li>This is handled in RestActionMapper between line 56 and 64</li>
    </ul>
  </li>
<li>If you want to monitor every URL or want to handle API limit, This could also be achieved from RestActionMapper, by calling respective service for verification </li> 
<li>Initiaalization of business entities can be done from RestActionMapper and setted in ActionMapper stack of struts2 to get at later point of time. For more info check line 83 in RestActionMapper class </li>   
<li>All necessary classes related to Exception are present in excepion package. You can customized them according to your needs</li>   
  <li>handle package contains Response, ResponseBuilder and RestActionMapper which can be customized according to business needs</li> 
</ul>
</p>

<p><b>Please feel free to ask your queries</b></p>

