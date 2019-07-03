Ext.onReady(function () {

    var springWriter = Ext.extend(Ext.data.JsonWriter, {
        encode: false,
        writeAllFields: true,
        listful: true,
        constructor: function (config) {
            springWriter.superclass.constructor.call(this, config);
        },
        render: function (params, baseParams, data) {
            // override the render function to insert the raw JSON payload
            params.jsonData = data;
        }
    });

    var myWriter = new springWriter();

    var myProxy = new Ext.data.HttpProxy({
        /*  restful: true,
         url: '/oneclickpurchase'*/
        api: {
            create:  {url: '/oneclickpurchase/create', method: 'POST'},
            read:    {url: '/oneclickpurchase/view', method: 'GET'},
            update:  {url: '/oneclickpurchase/update', method: 'PUT'},
            destroy: {url: '/oneclickpurchase/destroy', method: 'DELETE'}
        }
    });

    var OneClickPurchase = Ext.data.Record.create([
        {name: 'uid',   type: 'int'},
        {name: 'name',  type: 'string'},
        {name: 'phone', type: 'string'},
        {name: 'email', type: 'string'}
    ]);

    var myReader = new Ext.data.JsonReader({
        totalProperty: 'total',
        successProperty: 'success',
        idProperty: 'uid',
        root: 'data',
        messageProperty: 'message'
    }, OneClickPurchase);

    var store = new Ext.data.Store({
        proxy: myProxy,
        reader: myReader,
        writer: myWriter,
        autoSave: false
    });
    store.load();

    Ext.data.DataProxy.addListener('exception', function (proxy, type, action, options, res) {
        Ext.Msg.show({
            title: 'ERROR',
            msg: res.message,
            icon: Ext.MessageBox.ERROR,
            buttons: Ext.Msg.OK
        });
    });

    var editor = new Ext.ux.grid.RowEditor({
        saveText: 'Update'
    });

    // create grid
    var grid = new Ext.grid.GridPanel({
        store: store,
        columns: [
            {
                header: "ID",
                width: 130,
                sortable: true,
                dataIndex: 'uid',
                editor: {
                    xtype: 'textfield',
                    allowBlank: false
                }
            },
            {
                header: "NAME",
                width: 170,
                sortable: true,
                dataIndex: 'name',
                editor: {
                    xtype: 'textfield',
                    allowBlank: false
                }
            },
            {
                header: "PHONE",
                width: 170,
                sortable: true,
                dataIndex: 'phone',
                editor: {
                    xtype: 'textfield',
                    allowBlank: false
                }
            },
            {
                header: "EMAIL",
                width: 170,
                sortable: true,
                dataIndex: 'email',
                editor: {
                    xtype: 'textfield',
                    allowBlank: false
                }
            }
        ],
        viewConfig: {forcefit: true},
        plugins: [editor],
        title: 'One-click purchase',
        height: 300,
        width: 600,
        frame: true,
        tbar: [{
            iconCls: 'icon-add',
            text: 'Add purchase',
            handler: function () {
                var e = new OneClickPurchase({
                    name: 'New',
                    phone: '8122004545',
                    email: 'new@gmail.com'
                });
                editor.stopEditing();
                store.insert(0, e);
                grid.getView().refresh();
                grid.getSelectionModel().selectRow(0);
                editor.startEditing(0);
            }
        }, {
            iconCls: 'icon-delete',
            text: 'Remove purchase',
            handler: function () {
                editor.stopEditing();
                var s = grid.getSelectionModel().getSelections();
                for (var i = 0, r; r = s[i]; i++) {
                    store.remove(r);
                }
            }
        }, {
            iconCls: 'icon-save',
            text: 'Save All',
            handler: function () {
                store.save();
            }
        }]
    });

    grid.render('purchase-grid');
});
