//��DOM�ṹ������ɺ�bootstrap.js�ļ���������AngularJS��������������ִ��
define(['angular', 'app'], function(angular) {
	require(['domReady!'], function (document) {
		angular.bootstrap(document, ['webapp']);
  });
});

