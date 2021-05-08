import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { saleSum } from 'types/sale';
import { BASE_URL } from 'utils/requests';

type ChartData = {
    labels: string[];
    series: number[];
}

const DonutChart = () => {

    //state
    const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] });
    //setChartData updates the value of chartData
    //wrong way
    //let chartData: ChartData = {labels:[], series: []};

    useEffect(() => {
        //must be called just once, that's why it's inside the useEffect
        axios.get(`${BASE_URL}/sales/amount-by-seller`)
            .then((response) => {
                const data = response.data as saleSum[];
                const myLabels = data.map(x => x.sellerName);
                const mySeries = data.map(x => x.sum);

                //chartData = {labels: myLabels, series: mySeries};
                setChartData({ labels: myLabels, series: mySeries });
                //console.log(chartData);
            })
    },
        //list of objects that useEffect will monitor
        []);

    // const mockData = {
    //     series: [477138, 499928, 444867, 220426, 473088],
    //     labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    // }

    const options = {
        legend: {
            show: true
        }
    }

    // from apexcharts.com examples for React
    //even with update data, chart is not built. Need to use state
    return (
        <Chart
            options={{ ...options, labels: chartData.labels }}
            series={chartData.series}
            type="donut"
            height='240'
        />
    );
}

export default DonutChart;