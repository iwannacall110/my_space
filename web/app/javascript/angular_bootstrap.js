//��DOM�ṹ������ɺ�angular_bootstrap.js�ļ���������AngularJS��������������ִ��
define(['angular', 'domReady', 'app'], function(angular, domReady) {
    require(['domReady!'], function (document) {
        angular.bootstrap(document, ['webapp']);
    });
});