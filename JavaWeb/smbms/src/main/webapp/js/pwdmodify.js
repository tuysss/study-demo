var oldpassword = null;
var newpassword = null;
var rnewpassword = null;
var saveBtn = null;

$(function () {
	oldpassword = $("#oldpassword");
	newpassword = $("#newpassword");
	rnewpassword = $("#rnewpassword");
	saveBtn = $("#save");

	oldpassword.next().html("*");
	newpassword.next().html("*");
	rnewpassword.next().html("*");

	oldpassword.on("blur", function () {
		$.ajax({
			type: "GET",
			url: path + "/jsp/user.do",
			data: {method:"checkoldpwd", oldpassword: oldpassword.val()},
			success: function (data) {
				if (data.result == "true") {//��������ȷ
					validateTip(oldpassword.next(), {"color": "green"}, imgYes, true);
				} else if (data.result == "false") {//���������벻��ȷ
					validateTip(oldpassword.next(), {"color": "red"}, imgNo + " ԭ�������벻��ȷ", false);
				} else if (data.result == "sessionerror") {//��ǰ�û�session���ڣ������µ�¼
					validateTip(oldpassword.next(), {"color": "red"}, imgNo + " ��ǰ�û�session���ڣ������µ�¼", false);
				} else if (data.result == "error") {//����������Ϊ��
					validateTip(oldpassword.next(), {"color": "red"}, imgNo + " �����������", false);
				}
			},
			error: function (data) {
				//�������
				validateTip(oldpassword.next(), {"color": "red"}, imgNo + " �������", false);
			}
		});


	}).on("focus", function () {
		validateTip(oldpassword.next(), {"color": "#666666"}, "* ������ԭ����", false);
	});

	newpassword.on("focus", function () {
		validateTip(newpassword.next(), {"color": "#666666"}, "* ���볤�ȱ����Ǵ���6С��20", false);
	}).on("blur", function () {
		if (newpassword.val() != null && newpassword.val().length >= 6
			&& newpassword.val().length < 20) {
			validateTip(newpassword.next(), {"color": "green"}, imgYes, true);
		} else {
			validateTip(newpassword.next(), {"color": "red"}, imgNo + " �������벻���Ϲ淶������������", false);
		}
	});


	rnewpassword.on("focus", function () {
		validateTip(rnewpassword.next(), {"color": "#666666"}, "* ������������һ�µ�����", false);
	}).on("blur", function () {
		if (rnewpassword.val() != null && rnewpassword.val().length >= 6
			&& rnewpassword.val().length < 20 && newpassword.val() == rnewpassword.val()) {
			validateTip(rnewpassword.next(), {"color": "green"}, imgYes, true);
		} else {
			validateTip(rnewpassword.next(), {"color": "red"}, imgNo + " �����������벻һ�£�����������", false);
		}
	});


	saveBtn.on("click", function () {
		oldpassword.blur();
		newpassword.blur();
		rnewpassword.blur();
		// oldpassword.attr("validateStatus") == "true"
		// &&
		if ( oldpassword.attr("validateStatus") == "true"
			&&newpassword.attr("validateStatus") == "true"
			&& rnewpassword.attr("validateStatus") == "true") {
			if (confirm("ȷ��Ҫ�޸����룿")) {
				$("#userForm").submit();
			}
		}

	});
});