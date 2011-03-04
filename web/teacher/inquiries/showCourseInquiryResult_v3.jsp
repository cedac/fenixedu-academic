<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/fenix-renderers.tld" prefix="fr"%>

<html:xhtml />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<html xml:lang="pt-PT" xmlns="http://www.w3.org/1999/xhtml" lang="pt-PT"> 
<head> 
<title>QUC</title> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
 
<script type="text/javascript" src="<%= request.getContextPath() %>/javaScript/inquiries/jquery.min.js"></script> 
<script type="text/javascript">jQuery.noConflict();</script> 
<script type="text/javascript" src="<%= request.getContextPath() %>/javaScript/inquiries/highcharts.js"></script> 
<script type="text/javascript" src="<%= request.getContextPath() %>/javaScript/inquiries/exporting.js"></script> 
<script type="text/javascript">var example = 'bar-basic', theme = 'default';</script> 
<script type="text/javascript" src="<%= request.getContextPath() %>/javaScript/jquery/scripts.js"></script> 
<script type="text/javascript">Highcharts.theme = { colors: [] }; var highchartsOptions = Highcharts.getOptions();</script> 
 
<style media="print"> 
 
div.xpto {
page-break-inside: avoid;
page-break-after: always;
}
 
</style> 

<style> 
 

 
 
 
body {
font-size: 12px;
line-height: 15px;
font-family: Arial;
background: #eee;
text-align: center;
margin: 40px 20px 80px 20px;
}
h1 {
font-size: 22px;
line-height: 30px;
margin: 15px 0;
}
h2 {
font-size: 17px;
line-height: 30px;
margin: 40px 0 10px 0;
}
p {
margin: 10px 0 5px 0;
}
 
#page {
margin: 20px auto;
text-align: left;
padding: 20px 30px;
width: 900px;
background: #fff;
border: 1px solid #ddd;
/*
-moz-border-radius: 4px;
border-radius: 4px;
*/
}
 
/* ---------------------------
      STRUCTURAL TABLE 
--------------------------- */
 
table.structural {
border-collapse: collapse;
}
table.structural tr td {
padding: 0;
vertical-align: top;
}
 
/* ---------------------------
      TABLE GRAPH 
--------------------------- */
 
div.graph {
margin: 15px 0px 30px 0px;
}
 
table.graph, table.graph-2col {
color: #555;
}
 
table.graph {
border-collapse: collapse;
margin: 5px 0 5px 0;
/* width: 1000px; */
}
table.graph th {
text-align: left;
border-top: none;
border-bottom: 1px solid #ccc;
padding: 5px 0px;
font-weight: normal;
}
table.graph td {
text-align: left;
border-top: none;
border-bottom: 1px solid #ccc;
padding: 5px 5px !important;
text-align: center;
	vertical-align: middle !important;
}
table.graph tr.thead th {
border-bottom: 2px solid #ccc;
}
table.graph tr th:first-child {
padding: 5px 0px 5px 0px;
}
table.graph tr.thead th {
vertical-align: bottom;
text-align: center;
color: #555;
text-transform: uppercase;
font-size: 9px;
padding: 5px 5px;
background: #f5f5f5;
}
table.graph tr th {
width: 300px;
}
table.graph tr.thead th {
width: 55px;
}
table.graph tr.thead th.first {
width: 300px;
}
 
table.graph tr td.x1, table tr td.x2, table tr td.x3, table tr td.x4 {
background: #f5f5f5;
}
table.graph tr td.x1 {
border-right: 1px solid #ccc;
}
 
/* specific */
 
table.general-results  {
width: 100%;
}
 
table.general-results td {
width: 30px;
height: 32px;
}
 
table.teacher-results tr td {
width: 30px;
}
table.teacher-results tr th {
width: auto;
padding-left: 10px !important;
}
 
div.workload-left, div.workload-right   {
float: left;
width: 435px;
margin-top: 30px;
}
div.workload-left   {
padding-right: 30px;
}
 
 
tr.sub th {
padding-left: 20px !important;
}
 
 
div.result-audit {
margin: 20px 0 -20px 0;
}
div.result-audit span {
background: #555;
background: #C04439;
padding: 5px 10px;
/* border: 1px solid #ddd; */
color: #fff;
font-weight: bold;
}
 
 
 
tr.result-audit th span, tr.result-analysis th span {
/*
color: #c04439;
color: #b83326;
*/
font-weight: bold;
}
tr.result-audit, tr.result-analysis {
background: #f5f5f5;
}
 
 
/* ---------------------------
      TABLE GRAPH 2COL
--------------------------- */
 
table.graph-2col {
border-collapse: collapse;
margin: 5px 0 5px 0;
/* width: 1000px; */
}
table.graph-2col th {
text-align: left;
border-top: none;
border-bottom: 1px solid #ccc;
padding: 5px 0px;
font-weight: normal;
/* width: 380px; */
}
table.graph-2col td {
text-align: right !important;
border-top: none;
border-bottom: 1px solid #ccc !important;
padding: 5px 5px !important;
text-align: center;
}
 
/* ---------------------------
      INSIDE TABLE 
--------------------------- */
 
table.graph table {
width: 500px;
border-collapse: collapse;
}
table.graph table tr td {
border: none;
padding: 0 !important;
}
table.graph table tr td div {
}
 
/* ---------------------------
      GRAPH BARS 
--------------------------- */
 
div.graph-bar-horz {
height: 21px;
-moz-border-radius: 3px;
border-radius: 3px;
float: left;
background: #3573a5;
}
div.graph-bar-horz-number {
float: left;
padding-top: 2px;
padding-left: 6px;
}
 
/* right-aligned bars */
 
table.bar-right div {
float: right;
text-align: right;
}
 
table.bar-right div.graph-bar-horz-number {
padding-right: 10px;
}
 
 
div.bar-yellow, div.bar-red, div.bar-green, div.bar-blue {
width: 30px;
height: 19px;
-moz-border-radius: 3px;
border-radius: 3px;
text-align: center;
color: #fff;
padding-top: 2px;
font-weight: bold;
}
div.bar-yellow { background: #DDB75B; }
div.bar-red { background: #C04439; }
div.bar-green { background: #478F47; }
div.bar-blue { background: #3574A5; }
div.bar-purple { background: #743E8C; }
 
 
div.first-bar {
-moz-border-radius-topleft: 3px;
-moz-border-radius-bottomleft: 3px;
border-top-left-radius: 3px;
border-bottom-left-radius: 3px;
}
div.last-bar {
-moz-border-radius-topright: 3px;
-moz-border-radius-bottomright: 3px;
border-top-right-radius: 3px;
border-bottom-right-radius: 3px;
}
 
div.graph-bar-19-1,
div.graph-bar-19-2,
div.graph-bar-19-3,
div.graph-bar-19-4,
div.graph-bar-19-5,
div.graph-bar-19-6,
div.graph-bar-19-7,
div.graph-bar-19-8,
div.graph-bar-19-9,
div.graph-bar-grey {
height: 18px;
/*
-moz-border-radius: 3px;
border-radius: 3px;
*/
text-align: center;
color: #fff;
padding-top: 2px;
font-weight: bold;
}
div.graph-bar-yellow {
background: #e9a73d;
}
div.graph-bar-red {
background: #ce423d;
}
div.graph-bar-green {
background: #2d994a;
}
div.graph-bar-blue {
background: #006ca2;
}
div.graph-bar-grey {
background: #eee;
color: #888;
font-weight: normal;
-moz-border-radius: 3px;
border-radius: 3px;
}
 
 
 
.neutral div.graph-bar-19-1 { background: #528FBD; } /* red */ 
.neutral div.graph-bar-19-2 { background: #4C87B8; } /* red */
.neutral div.graph-bar-19-3 { background: #457EB2; } /* red */
.neutral div.graph-bar-19-4 { background: #3F76AC; } /* yellow */
.neutral div.graph-bar-19-5 { background: #396DA7; } /* green */
.neutral div.graph-bar-19-6 { background: #3265A1; } /* green */
.neutral div.graph-bar-19-7 { background: #2C5D9C; } /* green */
.neutral div.graph-bar-19-8 { background: #255495; } /* green */
.neutral div.graph-bar-19-9 { background: #204D91; } /* green */
 
table.neutral table {
border-collapse: separate !important;
}
 
 
.classification div.graph-bar-19-1 { background: #c04439; } /* red */ 
.classification div.graph-bar-19-2 { background: #ca623a; } /* red */
.classification div.graph-bar-19-3 { background: #cc7d3f; } /* red */
.classification div.graph-bar-19-4 { background: #ddb75b; } /* yellow */
.classification div.graph-bar-19-5 { background: #91a749; } /* green */
.classification div.graph-bar-19-6 { background: #74a14e; } /* green */
.classification div.graph-bar-19-7 { background: #5c9b4e; } /* green */
.classification div.graph-bar-19-8 { background: #478f47; } /* green */
.classification div.graph-bar-19-9 { background: #438a43; } /* green */
 
span.legend-bar {
padding: 0 3px;	
}
 
span.legend-bar-19-1,
span.legend-bar-19-2,
span.legend-bar-19-3,
span.legend-bar-19-4,
span.legend-bar-19-5,
span.legend-bar-19-6,
span.legend-bar-19-7,
span.legend-bar-19-8,
span.legend-bar-19-9 {
-moz-border-radius: 3px;
border-radius: 3px;
padding: 2px 5px;
font-size: 6px;
font-weight: bold;
}
 
 
table.neutral span.legend-bar-19-1 { background: #528FBD; }
table.neutral span.legend-bar-19-2 { background: #4C87B8; }
table.neutral span.legend-bar-19-3 { background: #457EB2; }
table.neutral span.legend-bar-19-4 { background: #3F76AC; }
table.neutral span.legend-bar-19-5 { background: #396DA7; }
table.neutral span.legend-bar-19-6 { background: #3265A1; }
table.neutral span.legend-bar-19-7 { background: #2C5D9C; }
table.neutral span.legend-bar-19-8 { background: #255495; }
table.neutral span.legend-bar-19-9 { background: #204D91; }
 
table.classification span.legend-bar-19-1 { background: #c04439; } /* red */ 
table.classification span.legend-bar-19-2 { background: #ca623a; } /* red */
table.classification span.legend-bar-19-3 { background: #cc7d3f; } /* red */
table.classification span.legend-bar-19-4 { background: #ddb75b; } /* yellow */
table.classification span.legend-bar-19-5 { background: #91a749; } /* green */
table.classification span.legend-bar-19-6 { background: #74a14e; } /* green */
table.classification span.legend-bar-19-7 { background: #5c9b4e; } /* green */
table.classification span.legend-bar-19-8 { background: #478f47; } /* green */
table.classification span.legend-bar-19-9 { background: #438a43; } /* green */
 
 
 
ul.legend-general {
list-style: none;
padding: 0;
margin: 10px 0;
color: #555;
}
ul.legend-general li {
/*display: inline;*/
padding-right: 10px;
padding: 2px 0;
}
 
 
span.legend-bar-1,
span.legend-bar-2,
span.legend-bar-3,
span.legend-bar-4,
span.legend-bar-5 {
-moz-border-radius: 3px;
border-radius: 3px;
padding: 2px 5px 0px 5px;
font-size: 8px;
font-weight: bold;
}
 
 
span.legend-bar-1 { background: #3574A5; }
span.legend-bar-2 { background: #478F47; }
span.legend-bar-3 { background: #DDB75B; }
span.legend-bar-4 { background: #C04439; }
span.legend-bar-5 { background: #743E8C; }
 
 
/* ---------------------------
      SUMMARY
--------------------------- */
 
div.summary table th {
border: none;
padding: 3px 0;
width: 200px;
}
div.summary table td {
text-align: left;
border: none;
padding: 3px 0;
}
 
 
/* ---------------------------
      TOOLTIPS
--------------------------- */
 
a {
color: #105c93;
}
a.help, a.helpleft {
position: relative;
text-decoration: none;
border: none !important;
width: 20px;
text-transform: none;
font-size: 12px;
font-weight: normal;
}
a.help span, a.helpleft span { display: none; }
a.help:hover, a.helpleft:hover {
z-index: 100;
border: 1px solic transparent;
}
a.help:hover span {
display: block !important;
display: inline-block;
width: 250px;
position: absolute;
top: 10px;
left: 30px;
text-align: left;
padding: 7px 10px;
background: #48869e;
color: #fff;
border: 3px solid #97bac6;
}
a.helpleft:hover span {
display: block !important;
display: inline-block;
width: 250px;
position: absolute;
top: 20px;
left: 20px;
text-align: left;
padding: 7px 10px;
background: #48869e;
color: #fff;
border: 3px solid #97bac6;
}
a.helpleft[class]:hover span {
right: 20px;
}
 
/* ---------------------------
      CHARTS
--------------------------- */
 
div.chart {
clear:both;
/* min-width: 600px; */
background: #eee;
padding: 10px;
/*
-moz-border-radius: 3px;
border-radius: 3px;
*/
}
 
 
table.graph tr td div.chart {
clear:both;
/* min-width: 600px; */
background: none;
padding: 0;
}
</style>

<bean:define id="resultsTitle" name="answersResultsSummaryBean" property="inquiryGroupQuestion.inquiryQuestionHeader.title"/>

<bean:define id="answerResultsJS">
<script type="text/javascript"> 
var chart;
jQuery(document).ready(function() {
   chart = new Highcharts.Chart({
	   colors: [
	            '#0072AA', '#3B91B8', '#00518B'
	        ],
	  chart: {
	     renderTo: 'pie1',
	     marginRight: 20,
	     marginLeft: 20,
	     marginTop: 50,
	   	 marginBottom: 50
	  },
      title: {
         text: <%= "'" + resultsTitle.toString() + "'"%>
      },
      credits: {
          enabled: false
       },
 	  exporting: {
          enabled: false
       },
       plotArea: {
          shadow: null,
          borderWidth: null,
          backgroundColor: null
       },
       tooltip: {
          formatter: function() {
             return '<b>'+ this.point.name +'</b>: '+ this.y +' %';
          }
       },
       plotOptions: {
          pie: {
             allowPointSelect: true,
             cursor: 'pointer',
             dataLabels: {
                enabled: true,
                color: Highcharts.theme.textColor || '#000000',
                connectorColor: Highcharts.theme.textColor || '#000000',
                formatter: function() {
                   return '<b>'+ this.point.name +'</b>: '+ this.y +' %';
                }
             }
          }
       },
       series: [{
         type: 'pie',
         name: 'Browser share',
         data: [
            <logic:iterate id="questionResult" name="answersResultsSummaryBean" property="questionsResults">
				<bean:define id="questionLabel" name="questionResult" property="inquiryQuestion.label"/>				
				<bean:define id="questionValue" name="questionResult" property="presentationValue"/>	  
				<logic:notEqual value="0" name="questionValue">          
	            	<%= "['" + questionLabel.toString() + "', " + questionValue + "],"%>
	            </logic:notEqual>  	            
            </logic:iterate>
         ]
      }]
   });
});
</script> 
</bean:define>

<bean:define id="workLoadTitle" name="workLoadaSummaryBean" property="inquiryGroupQuestion.inquiryQuestionHeader.title"/>

<bean:define id="workloadJS">
<script type="text/javascript"> 
var chart;
jQuery(document).ready(function() {
   chart = new Highcharts.Chart({
      colors: [
          '#0072AA', '#3B91B8', '#00518B'
      ],
      chart: {
         renderTo: 'graphic3',
         defaultSeriesType: 'bar'
      },
      title: {
         text: <%= "'" + workLoadTitle.toString() + "'" %>
      },
      credits: {
         enabled: false
      },
	  exporting: {
         enabled: false
      },
      xAxis: {
         categories: ['Previsto', 'Estimado']
      },
      yAxis: {
         min: 0,
         title: {
            text: ''
         }
      },
      legend: {
         backgroundColor: Highcharts.theme.legendBackgroundColorSolid || '#FAFAFA',
         reversed: true
      },
      tooltip: {
         formatter: function() {
            return ''+
                this.series.name +': '+ this.y +'';
         }
      },
      plotOptions: {
         series: {
            stacking: 'normal'
         }
      },
           series: [
			<logic:iterate id="questionResult" name="workLoadaSummaryBean" property="questionsResults">
				<bean:define id="questionLabel" name="questionResult" property="inquiryQuestion.label"/>
				<bean:define id="questionValue" name="questionResult" property="presentationValue"/> 
	            <%= "{ name: '" + questionLabel.toString() + "', data: [2" /*+ questionValue*/ + ",3]},"%>
			</logic:iterate>
			]
   });
});
</script> 
</bean:define> 

<!--  bean:define id="ucEvaluationsTitle" name="ucEvaluationsBlockBean" property="inquiryBlock.inquiryQuestionHeader.title"/-->

<bean:define id="ucEvaluationsJS">
<script type="text/javascript"> 
var chart;
jQuery(document).ready(function() {
   chart = new Highcharts.Chart({
      colors: [
         '#0072AA', '#00518B'
      ],
      chart: {
         renderTo: 'graphic1',
         defaultSeriesType: 'column'
      },
      title: {
         text: <%= "Classifica��es UC" /*"'" + ucEvaluationsTitle.toString() + "'"*/ %>
      },
      credits: {
         enabled: false
      },
	  exporting: {
         enabled: false
      },
      xAxis: {
         categories: [
			<%--<logic:iterate id="groupResult" name="ucEvaluationsBlockBean" property="groupsResults" type="net.sourceforge.fenixedu.dataTransferObject.inquiries.GroupResultsSummaryBean">
				<bean:define id="groupTitle">
					<%= groupResult.getInquiryGroupQuestion().getInquiryQuestionHeader().getTitle().toString() %>
				</bean:define>
				<%= "'" + groupTitle + "',"%>
			</logic:iterate>--%>
         ]
      },
      yAxis: {
         min: 0,
         title: {
            text: ''
         }
      },
      legend: {
         layout: 'vertical',
         backgroundColor: Highcharts.theme.legendBackgroundColor || '#FAFAFA',
         align: 'left',
         verticalAlign: 'top',
         x: 50,
         y: 70,
         floating: true,
         shadow: true
      },
      tooltip: {
         formatter: function() {
            return ''+
               this.x +': '+ this.y;
         }
      },
      plotOptions: {
         column: {
            pointPadding: 0.2,
            borderWidth: 0
         }
      },
      series: [{
         name: 'Real',
         data: [<%--
				<logic:iterate id="groupResultBean" name="ucEvaluationsBlockBean" property="groupsResults">
					<logic:iterate indexId="iter" id="questionResult" name="groupResultBean" property="questionsResults">
						<logic:equal name="iter" value="0">
							<bean:write name="questionResult" property="presentationValue"/>,
						</logic:equal>
					</logic:iterate>
				</logic:iterate>
                --%>]
      },
		{
         name: 'Alunos',
         data: [<%--
				<logic:iterate id="groupResultBean" name="ucEvaluationsBlockBean" property="groupsResults">
					<logic:iterate indexId="iter" id="questionResult" name="groupResultBean" property="questionsResults">
						<logic:equal name="iter" value="1">
							<bean:write name="questionResult" property="presentationValue"/>,
						</logic:equal>
					</logic:iterate>
				</logic:iterate>
               --%>]
      }
	  ]
   });
});
--</script>
</bean:define>
 
<bean:write name="answerResultsJS" filter="false"/>
<bean:write name="workloadJS" filter="false"/>
<bean:write name="ucEvaluationsJS" filter="false"/>

</head>

<body class="survey">  
 
<div id="page"> 
 
<fmt:setBundle basename="resources.InquiriesResources" var="INQUIRIES_RESOURCES"/>

<p>
	<em><bean:write name="executionPeriod" property="semester"/>� Semestre de <bean:write name="executionPeriod" property="executionYear.year"/></em>
</p>

<h1>QUC - Resultados dos Inqu�ritos aos Alunos: <bean:write name="executionCourse" property="name"/></h1>

<p><bean:write name="executionDegree" property="degreeName"/></p>

<h2>Resultados gerais da UC e estat�sticas de preenchimento</h2>
<table class="structural" style="margin-top: 5px;"> 
	<tr> 
		<td style="padding-right: 20px;"> 
			<fr:view name="ucGroupResultsSummaryBean" layout="general-result-resume"/>			
			<table> 
				<tr> 
					<td> 
						<p style="margin-top: 15px;">Legenda:</p> 
						<ul class="legend-general" style="margin-top: 0px;"> 
							<li><span class="legend-bar-2">&nbsp;</span> Regular</li> 
							<li><span class="legend-bar-3">&nbsp;</span> A melhorar</li> 
							<li><span class="legend-bar-4">&nbsp;</span> Inadecuado</li> 
						</ul> 
					</td> 
					<td style="padding-left: 30px;"> 
						<p style="margin-top: 15px;">Legenda (carga de trabalho):</p> 
						<ul class="legend-general" style="margin-top: 0px;"> 
							<li><span class="legend-bar-2">&nbsp;</span> De acordo com o previsto</li> 
							<li><span class="legend-bar-3">&nbsp;</span> Acima do previsto</li> 
							<li><span class="legend-bar-5">&nbsp;</span> Abaixo do previsto</li> 
						</ul> 
					</td> 
				</tr> 
			</table>
		</td> 
		<td style="width: 500px;"> 
			<div class="chart"> 
				<div id="pie1" class="highcharts-container" style="height: 225px;"></div> 
			</div>
		</td> 
	</tr> 
</table> 

<bean:define id="ucGeneralData">
	<table class="graph-2col">
		<logic:iterate id="ucData" name="ucGeneralDataSummaryBean" property="questionsResults">
			<tr>
				<th style="width: 240px;"><bean:write name="ucData" property="inquiryQuestion.label"/></th>
				<td>
					<logic:notEmpty name="ucData" property="questionResult">
					<logic:equal value="PERCENTAGE" name="ucData" property="questionResult.resultType">
						<bean:write name="ucData" property="presentationValue"/>%
					</logic:equal>
					<logic:notEqual value="PERCENTAGE" name="ucData" property="questionResult.resultType">
						<bean:write name="ucData" property="presentationValue"/>
					</logic:notEqual>
					</logic:notEmpty>
				</td>
			</tr>
		</logic:iterate>
	</table>	
</bean:define> 

<logic:iterate indexId="iter" id="blockResult" name="blockResultsSummaryBeans">
	<h2><bean:write name="blockResult" property="inquiryBlock.inquiryQuestionHeader.title"/></h2>
	<logic:equal value="0" name="iter">
		<div class="chart"> 
			<div id="graphic3" class="highcharts-container" style="height: 225px;"></div>
		</div>		
	</logic:equal>
	<logic:equal value="2" name="iter">
		<bean:write name="ucGeneralData" filter="false"/>
		<div class="chart" style="margin: 20px 0 30px 0;">
			<div id="graphic1" class="highcharts-container" style="height: 225px;"></div>
		</div>
	</logic:equal>
	<logic:iterate id="groupResult" name="blockResult" property="groupsResults">
		<fr:view name="groupResult" />
	</logic:iterate>
</logic:iterate>

</div>

</body>
</html>