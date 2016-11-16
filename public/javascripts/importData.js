function allData ()
{
    //Bar graph
    var svg = dimple.newSvg("body", 600, 400);
    var data = [
        {"Region":"NA","Sales":4392.950000000332},
        {"Region":"EU","Sales":2434.13000000055},
        {"Region":"JP","Sales":1291.0199999999018},
        {"Region":"Other","Sales":797.7499999998826},
        {"Region":"Global","Sales":8920.440000001283}]
    var chart = new dimple.chart(svg, data);
    chart.addCategoryAxis("x", "Region");
    chart.addMeasureAxis("y", "Sales");
    chart.addSeries(null, dimple.plot.bar);
    chart.draw();
}







function data () {
/// Pie Chart		
var data=[
        {"Region":"NA","Sales":4392.950000000332},
        {"Region":"EU","Sales":2434.13000000055},
        {"Region":"JP","Sales":1291.0199999999018},
        {"Region":"Other","Sales":797.7499999998826},
        {"Region":"Global","Sales":8920.440000001283}]
var width = 800,
    height = 450,
    radius = Math.min(width, height) / 2;

var color = d3.scale.category20();

var arc = d3.svg.arc()
    .outerRadius(radius - 10)
    .innerRadius(0);

var pie = d3.layout.pie()
    .sort(null)
    .value(function (d) {
    return d.Sales;
});

var svg = d3.select("body").append("svg")
    .attr("width", width)
    .attr("height", height)
    .append("g")
    .attr("transform", "translate(" + width / 2 + "," + height / 2 + ")");

    var g = svg.selectAll(".arc")
        .data(pie(data))
        .enter().append("g")
        .attr("class", "arc");

    g.append("path")
        .attr("d", arc)
        .style("fill", function (d) {
        return color(d.data.Region);
    });

    g.append("text")
        .attr("transform", function (d) {
        return "translate(" + arc.centroid(d) + ")";
    })
        .attr("dy", ".35em")
        .style("text-anchor", "middle")
        .text(function (d) {
        return d.data.Region;
    });}
