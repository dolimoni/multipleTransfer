Ext.application({
    name: 'MyApp',
    appFolder: 'app',
    autoCreateViewport: true,
    controllers: [
    'AuthenticationController',
    'VirementController'
    ],
    launch: function() {
     console.log("Launching MyApp");
    }
});