Ext.define('luter.ux.EchartsPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.echartspanel',
    liquidLayout: true,
    cls: 'chart-body',
    initComponent: function () {
        var me = this;
        if (!me.height) {
            showFailMesg({
                msg: '请正确配置图表参数:height'
            })
        }
        if (!me.option) {
            showFailMesg({
                msg: '请正确配置图表参数:option'
            })
        }
        me.on("boxready", function () {
            me.echarts = echarts.init(me.getEl().dom);
            if (me.option) {
                me.echarts.setOption(me.option);
            }
        });
        me.callParent();
        me.on("resize", function (ta, width, height, ow, oh, e) {
            me.echarts.resize(ow - 10, oh - 5);
        });
    }
});
