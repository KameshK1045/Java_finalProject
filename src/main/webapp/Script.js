/**
 * 
 */
let xht = new XMLHttpRequest();
let sendString = "";
let plname, plNo, plState, plDob, plrole, plObj;
let matchId, matchName, placeofmatch, dateofmatch;
let cookie, cookie2, cookie3;
let plNoUpdate, plNameUpdate, plstateUpdate, pldateUpdate;

function Validate() {
	xht.onreadystatechange = function() {
		console.log(this.readyState);

		if (xht.readyState == 4 && xht.status == 200) {
			let json = JSON.parse(xht.responseText);
			console.log(xht.responseText);
			if (json.StatusCode == 200 && json.Role == "ADMIN") {
				alert("welcome");
				window.location.href = "Admin.html";
			} else if (json.StatusCode == 200 && json.Role == "PLAYER") {
				window.location.href = "Player.html";
			} else {
				alert(json.Message);
			}
		}

	}
	let obj = {};
	obj.name = document.getElementById("userName").value;
	obj.passWord = document.getElementById("passWord").value;
	let profile = document.getElementsByClassName("profile");
	profile.innerText = obj.name;
	xht.open("POST", "http://localhost:8080/Cricbuzz/LoginServlet");
	xht.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xht.send("name=" + obj.name + "&pass=" + obj.passWord);

}



let main = document.getElementById("main");
let addform = document.getElementById("addform");
let addform1 = document.getElementById("addform1");
let addform2 = document.getElementById("addform2");
let addform3 = document.getElementById("addform3");
let addform4 = document.getElementById("addform4");
let addform5 = document.getElementById("addform5");
let addform7 = document.getElementById("addform7");
let matchStart = document.getElementById("matchStart");
let pl = document.getElementById("pl");
let checkList = document.getElementById("checkList");
let teamAndCaptain = document.getElementById("teamAndCaptain");
let nextButton = document.getElementById("nextButton");
let submitAdd = document.getElementById("submitAdd");
let pldetails = document.getElementById("pldetails");
let toss = document.getElementById("toss");
let usa = document.getElementById("usa");
let h = document.getElementById("h");
let t = document.getElementById("t");
let chosen = document.getElementById("chosen");
let addform6 = document.getElementById("addform6");
let results = document.getElementById("results");
let team1result = document.getElementById("team1result");
let team2result = document.getElementById("team2result");

let profileAdmin = document.getElementById("profileAdmin");
let match = document.getElementById("match");
let player = document.getElementById("player");
let add = document.getElementById("add");
let team = document.getElementById("team");
let details = document.getElementById("details");
let result = document.getElementById("result");

let scorecard = document.getElementById("scorecard");

let team1playerscore = document.getElementById("team1playerscore");
let team2playerscore = document.getElementById("team2playerscore");
let team1NameForResult = document.getElementById("team1NameForResult");
let team2NameForResult = document.getElementById("team2NameForResult");
let team1score = document.getElementById("team1score");
let team2score = document.getElementById("team2score");
let teamName = document.getElementById("teamName");

let detName = document.getElementById("detName");
let detPhone = document.getElementById("detPhone");
let detState = document.getElementById("detState");
let detbirth = document.getElementById("detbirth");
let proImage = document.getElementById("proImage");
let updates = document.getElementById("updates");

let runs = document.getElementById("runs");
let hs = document.getElementById("hs");
let matchesNos = document.getElementById("matchesNos");
let playerNameForTeam = document.getElementById("playerNameForTeam");
let matchboard = document.getElementById("matchboard");

profileAdmin.addEventListener("click", function() {
	profileAdmin.style.backgroundColor = "#5B6176";
	match.style.background = "none";
	updates.style.background = "none";
	player.style.background = "none";
	add.style.background = "none";
	team.style.background = "none";
	details.style.background = "none";
	result.style.background = "none";
	profileAdmin.style.borderRadius = "10px";
});
match.addEventListener("click", function() {
	match.style.backgroundColor = "#5B6176";
	profileAdmin.style.background = "none";
	updates.style.background = "none";
	player.style.background = "none";
	add.style.background = "none";
	team.style.background = "none";
	details.style.background = "none";
	result.style.background = "none";
	match.style.borderRadius = "10px";
});
player.addEventListener("click", function() {
	player.style.backgroundColor = "#5B6176";
	profileAdmin.style.background = "none";
	match.style.background = "none";
	add.style.background = "none";
	team.style.background = "none";
	details.style.background = "none";
	result.style.background = "none";
	player.style.borderRadius = "10px";
});
add.addEventListener("click", function() {
	add.style.backgroundColor = "#5B6176";
	profileAdmin.style.background = "none";
	match.style.background = "none";
	player.style.background = "none";
	team.style.background = "none";
	details.style.background = "none";
	result.style.background = "none";
	add.style.borderRadius = "10px";
});
team.addEventListener("click", function() {
	team.style.backgroundColor = "#5B6176";
	profileAdmin.style.background = "none";
	match.style.background = "none";
	player.style.background = "none";
	add.style.background = "none";
	details.style.background = "none";
	result.style.background = "none";
	team.style.borderRadius = "10px";
});
details.addEventListener("click", function() {
	details.style.backgroundColor = "#5B6176";
	profileAdmin.style.background = "none";
	match.style.background = "none";
	player.style.background = "none";
	add.style.background = "none";
	team.style.background = "none";
	result.style.background = "none";
	details.style.borderRadius = "10px";
});
result.addEventListener("click", function() {
	result.style.backgroundColor = "#5B6176";
	profileAdmin.style.background = "none";
	match.style.background = "none";
	player.style.background = "none";
	add.style.background = "none";
	team.style.background = "none";
	details.style.background = "none";
	result.style.borderRadius = "10px";
});






function playerReg() {
	addform1.style.display = "none";
	addform2.style.display = "none";
	addform3.style.display = "none";
	addform.style.display = "flex";
	addform4.style.display = "none";
	addform5.style.display = "none";
	addform6.style.display = "none";
	addform7.style.display = "none";
	if (addform.childElementCount == 0) {
		let title = document.createElement("div");
		addform.appendChild(title).setAttribute("class", "title");
		title.innerHTML = "<p class='reg'>REGISTRATION</p>"
		let form = document.createElement("div");
		addform.appendChild(form).setAttribute("class", "form");
		form.innerHTML = "<input type='text' id='name' placeholder='Enter Your Name'><br><br><input type='number' id='no' placeholder='Enter Your Number'><br><br><input type='text' id='state' placeholder='Enter Your State'><br><br><h1>Date of Birth</h1><input type='date' id='date'><br><br><select name='Role' id='role'><option value='BATSMAN'>BATSMAN</option><option value='BOWLER'>BOWLER</option><option value='ALL-ROUNDER'>ALL-ROUNDER</option><option value='WICKET-KEEPER'>WICKET-KEEPER</option></select><br><br><button class='submit' value='submit' onclick='submit()'>Submit</button>";

	}
}

function submit() {
	let regObj = {};
	regObj.name = document.getElementById("name").value;
	regObj.no = document.getElementById("no").value;
	regObj.state = document.getElementById("state").value;
	regObj.date = document.getElementById("date").value;
	regObj.role = document.getElementById("role").value;
	if (regObj.name != "" && regObj.no != "" && regObj.state != "" && regObj.date != "" && regObj.role != "") {
		console.log(regObj);
		xht.open("POST", "http://localhost:8080/Cricbuzz/Signup");
		xht.setRequestHeader("Content-Type", "application/json");
		xht.send(JSON.stringify(regObj));
	} else {
		alert("Please fill All Details");
	}

	xht.onreadystatechange = function() {
		if (xht.readyState == 4 && xht.status == 200) {
			console.log(xht.responseText);
			let json = JSON.parse(xht.responseText);
			if (json.StatusCode == 200 && json.Message == "succesfully Registered") {
				alert("Your Password " + json.password + "\n" + "Succesfully registered");
				document.getElementById("name").value = "";
				document.getElementById("no").value = "";
				document.getElementById("state").value = "";
				document.getElementById("date").value = "";
				document.getElementById("role").value = "";


			} else {
				alert("Something went wrong");
			}
		}
	}

}


function matchAdded() {
	addform.style.display = "none";
	addform2.style.display = "none";
	addform3.style.display = "none";
	addform1.style.display = "flex";
	addform4.style.display = "none";
	addform5.style.display = "none";
	addform6.style.display = "none";
	addform7.style.display = "none";
	if (addform1.childElementCount == 0) {
		let title1 = document.createElement("div");
		addform1.appendChild(title1).setAttribute("class", "title1");
		title1.innerHTML = "<p class='reg'>REGISTRATION</p>"
		let form1 = document.createElement("div");
		addform1.appendChild(form1).setAttribute("class", "form1");
		form1.innerHTML = "<input type='text' id='tName' placeholder='Enter the Tournament'><br><br><input type='text' id='place' placeholder='Enter Your Place'><br><br><h1>Date of Match</h1><input type='date' id='date'><br><br><br><br><br><br><br><br><button class='submit' value='submit1' onclick='submit1()'>Submit</button>";
	}
}

function submit1() {

	xht.onreadystatechange = function() {
		let json = JSON.parse(xht.responseText);
		console.log(xht.responseText);
		if (json.StatusCode == 200 && json.Message == "Succesfully Registered") {
			alert(json.Message);
			document.getElementById("tName").value = "";
			document.getElementById("place").value = "";
			document.getElementById("date").value = "";

		} else {
			alert(json.Message);
		}
	}
	let matchObj = {};
	matchObj.tName = document.getElementById("tName").value;
	matchObj.place = document.getElementById("place").value;
	matchObj.date = document.getElementById("date").value;
	console.log(matchObj);
	if (matchObj.id != "" && matchObj.tName != "" && matchObj.place != "" && matchObj.date != "") {
		xht.open("POST", "http://localhost:8080/Cricbuzz/Matchadded");
		xht.setRequestHeader("Content-type", "application/json");
		xht.send(JSON.stringify(matchObj));
	} else {
		alert("Please fill all details");
	}
}

function cookieCheck() {
	console.log(document.cookie);
	cookie = document.cookie.split(";");
	cookie2 = cookie[0].split("=");
	if (cookie2[1] == "" || cookie == "") {
		window.location.href = "NewFile.html";
	}
	cookie3 = cookie[1].split("=");
	sendString += cookie3[1];
	console.log(sendString);
	console.log(cookie);
	console.log(cookie2);
	console.log(cookie2[1]);
	console.log(cookie3);

}

function Playeradd() {
	submitAdd.style.display = "none";
	nextButton.style.display = "block";
	addform.style.display = "none";
	addform2.style.display = "none";
	addform1.style.display = "none";
	addform3.style.display = "none";
	addform4.style.display = "flex";
	addform5.style.display = "none";
	addform6.style.display = "none";
	addform7.style.display = "none";
	checkList.style.display = "flex";
	teamAndCaptain.style.display = "none";
	xht.onreadystatechange = function() {
		if (xht.readyState == 4 && xht.status == 200) {
			//            console.log(xht.responseText);
			plObj = JSON.parse(xht.responseText);
			//            console.log(plObj);
			for (i = 0; i < plObj.length; i++) {
				//				console.log("hi");
				let nameOfthePlayer = plObj[i].PlName;
				console.log(nameOfthePlayer);
				if (plObj[i].PlRole != "ADMIN" && plObj[i].plStatus != "Unavailable") {
					plname = plObj[i].PlName;
					plNo = plObj[i].PlNo;
					plState = plObj[i].PLState;
					plDob = plObj[i].PLDob;
					plrole = plObj[i].PlRole;
					if (i < plObj.length) {
						if (checkList.childElementCount < plObj.length - 1) {
							Playeradd1();
						}
					}
				}
			}
		}
	}


	xht.open("GET", "http://localhost:8080/Cricbuzz/ShowServlet");
	xht.setRequestHeader("Content-Type", "application/json");
	xht.send();
}

let k = 0;

function Playeradd1() {
	//    console.log(count);
	//    if(checkList.childElementCount != count){
	let namesvekka = document.createElement("div");
	checkList.appendChild(namesvekka).setAttribute("id", "namesvekka" + k);
	namesvekka.setAttribute("class", "namesvekka");
	let checkboxeses = document.createElement("input");
	namesvekka.appendChild(checkboxeses).setAttribute("type", "checkbox");
	checkboxeses.setAttribute("id", "checkboxeses" + (k));
	checkboxeses.setAttribute("value", plNo);
	checkboxeses.setAttribute("name", plname);
	namesvekka.append(plname);
	k++;
	//    }

}

function PlayerDetails() {
	addform.style.displa = "none";
	addform2.style.display = "none";
	addform1.style.display = "none";
	addform3.style.display = "flex";
	addform4.style.display = "none";
	addform5.style.display = "none";
	addform6.style.display = "none";
	addform7.style.display = "none";
	pldetails.style.display = "none";
	pl.style.display = "flex";
	xht.onreadystatechange = function() {
		if (xht.readyState == 4 && xht.status == 200) {
			console.log(xht.responseText);
			plObj = JSON.parse(xht.responseText);
			console.log(plObj);
			for (i = 0; i < plObj.length; i++) {
				if (plObj[i].PlRole != "ADMIN") {
					plname = plObj[i].PlName;
					plNo = plObj[i].PlNo;
					plState = plObj[i].PLState;
					plDob = plObj[i].PLDob;
					plrole = plObj[i].PlRole;
					if (pl.childElementCount < plObj.length - 1) {
						showThePlayers();
					}
				}
			}
		}
	}


	xht.open("GET", "http://localhost:8080/Cricbuzz/ShowServlet");
	xht.setRequestHeader("Content-Type", "application/json");
	xht.send();
}

function showThePlayers() {
	addform.style.display = "none";
	addform2.style.display = "none";
	addform1.style.display = "none";
	addform3.style.display = "flex";
	addform4.style.display = "none";
	addform5.style.display = "none";
	addform6.style.display = "none";
	let plObj2 = {};
	plObj2.name = plname;
	plObj2.no = plNo;
	plObj2.state = plState;
	plObj2.date = plDob;
	if (pl.childElementCount != plObj.length) {
		let plname1 = document.createElement("div");
		pl.appendChild(plname1).setAttribute("id", "plname1");
		plname1.setAttribute("onclick", "mydetails(this)");
		plname1.innerText = plname;
		plname1.setAttribute("name", plname + "," + plNo + "," + plState + "," + plDob);
		//    let plphone1 = document.createElement("div");
		//    pl.appendChild(plphone1).setAttribute("id", "plphone1")
		//    plphone1.innerText = plNo;
		//    let plstate1 = document.createElement("div");
		//    pl.appendChild(plstate1).setAttribute("id", "plstate1")
		//    plstate1.innerText = plState;
		//    let pldob1 = document.createElement("div");
		//    pl.appendChild(pldob1).setAttribute("id", "pldob1")
		//    pldob1.innerText = plDob;
		//    let plrole1 = document.createElement("div");
		//    pl.appendChild(plrole1).setAttribute("id", "plrole1")
		//    plrole1.innerText = plrole;
	}


}

function matchdetails() {
	addform.style.display = "none";
	addform1.style.display = "flex";
	addform2.style.display = "none";
	addform3.style.display = "none";
	if (addform1.childElementCount == 0) {
		addform1.appendChild(matchboard);
	}
	xht.onreadystatechange = function() {
		if (xht.readyState == 4 && xht.status == 200) {
			let jsonMatch = JSON.parse(xht.responseText);
			console.log(jsonMatch);
			for (let i = 0; i < jsonMatch.length; i++) {
				matchId = jsonMatch[i].matchId;
				matchName = jsonMatch[i].matchName;
				placeofmatch = jsonMatch[i].place;
				dateofmatch = jsonMatch[i].date;
				if (matchboard.childElementCount < jsonMatch.length) {
					showThematch();
				}
			}
		}
	}

	xht.open("GET", "http://localhost:8080/Cricbuzz/MatchServlet");
	xht.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xht.send();


}

function showThematch() {
	let matchshow = document.createElement("div");
	matchboard.appendChild(matchshow).setAttribute("id", "matchshow");
	let matchshowId = document.createElement("div");
	matchshow.appendChild(matchshowId).setAttribute("id", "matchshowId");
	matchshowId.innerText = matchId;
	let matchshowName = document.createElement("div");
	matchshow.appendChild(matchshowName).setAttribute("id", "matchshowName");
	matchshowName.innerText = matchName;
	let matchshowPlace = document.createElement("div");
	matchshow.appendChild(matchshowPlace).setAttribute("id", "matchshowPlace");
	matchshowPlace.innerText = placeofmatch;
	let matchshowDate = document.createElement("div");
	matchshow.appendChild(matchshowDate).setAttribute("id", "matchshowDate");
	matchshowDate.innerText = dateofmatch;
}
let teams;
let getvalues2 = [];
let getvalues3 = [];


function submit2() {

	xht.onreadystatechange = function() {
		if (xht.readyState == 4 && xht.status == 200) {
			let jsonTeam = JSON.parse(xht.responseText);
			if (jsonTeam.StatusCode == 200 && jsonTeam.Message == "Successfully Added") {
				alert(jsonTeam.Message);
				document.getElementById("teams").value = "";
				document.getElementById("Captain").value = "";
				teamAndCaptain.style.display = "none";
				nextButton.style.display = "block";
				submitAdd.style.display = "none";
				Playeradd();
				window.location.href = "";

			} else {
				alert(jsonTeam.Message);
			}
		}
	}
	let teamObj = {};
	teamObj.teamName = document.getElementById("teams").value;
	teamObj.captain = document.getElementById("Captain").value;
	teamObj.players = getvalues3.toString();
	//    
	xht.open("POST", "http://localhost:8080/Cricbuzz/TeamServlet");
	xht.setRequestHeader("Content-Type", "application/json");
	xht.send(JSON.stringify(teamObj));
	//    
	console.log(teamObj);


}

function nexts() {
	let getvalues;
	let che = document.getElementById("checkList").childNodes.length;
	console.log(che);

	for (let i = 0; i < che; i++) {
		getvalues = document.getElementById("checkboxeses" + i);
		if (getvalues.checked) {
			getvalues2.push(document.getElementById("checkboxeses" + i).getAttribute("name"));
			getvalues3.push(document.getElementById("checkboxeses" + i).value);
			//            console.log(getvalues2);

		}
	}
	//	 document.getElementById("teams").style.display="flex";
	//    console.log(getvalues2.length);
	//    console.log(getvalues2);
	if (getvalues2.length == 11) {
		//    console.log(getvalues2);
		checkList.style.display = "none";
		teamAndCaptain.style.display = "flex";
		let Captain = document.getElementById("Captain");
		for (let j = 0; j < getvalues2.length; j++) {
			let option = document.createElement("option");
			option.value = getvalues2[j];
			option.text = getvalues2[j];
			Captain.add(option);
		}

		nextButton.style.display = "none";
		submitAdd.style.display = "block";
	} else {
		alert("Select 11 players only");
		getvalues2 = [];
	}

}

function showTheProfile() {
	addform.style.display = "none";
	addform1.style.display = "none";
	addform2.style.display = "flex";
	addform3.style.display = "none";
	addform4.style.display = "none";
	addform5.style.display = "none";
	addform6.style.display = "none";
	addform7.style.display = "none";
	let adname = document.getElementById("adname");
	adname.onmouseover = function() {
		adname.innerText = "Name";
		adname.style.color = "black"
	}
	adname.onmouseout = function() {
		adname.style.color = "white";
		adname.innerText = '';
		adname.innerText = plname;
	}
	let adphone = document.getElementById("adphone");
	adphone.onmouseover = function() {
		adphone.innerText = "Phone Number";
		adphone.style.color = "black"
	}
	adphone.onmouseout = function() {
		adphone.style.color = "white";
		adphone.innerText = '';
		adphone.innerText = plNo;
	}
	let adState = document.getElementById("adState");
	adState.onmouseover = function() {
		adState.innerText = "State";
		adState.style.color = "black"
	}
	adState.onmouseout = function() {
		adState.style.color = "white";
		adState.innerText = '';
		adState.innerText = plState;
	}
	let adbirth = document.getElementById("adbirth");
	adbirth.onmouseover = function() {
		adbirth.innerText = "DOB";
		adbirth.style.color = "black"
	}
	adbirth.onmouseout = function() {
		adbirth.style.color = "white";
		adbirth.innerText = '';
		adbirth.innerText = plDob;
	}
	xht.onreadystatechange = function() {
		if (xht.readyState == 4 && xht.status == 200) {
			//            console.log(xht.responseText);
			plObj = JSON.parse(xht.responseText);
			//            console.log(plObj);
			for (i = 0; i < plObj.length; i++) {
				if (plObj[i].PlRole == "ADMIN") {
					plname = plObj[i].PlName;
					plNo = plObj[i].PlNo;
					plState = plObj[i].PLState;
					plDob = plObj[i].PLDob;
					plrole = plObj[i].PlRole;
				}
			}
		}

		adname.innerText = plname;
		adphone.innerText = plNo;
		adState.innerText = plState;
		adbirth.innerText = plDob;
	}


	xht.open("GET", "http://localhost:8080/Cricbuzz/ShowServlet");
	xht.setRequestHeader("Content-Type", "application/json");
	xht.send();
}

function forgetPassword() {
	let log = document.getElementById("log");
	log.style.display = "none";
	let forgetPasswordDiv = document.getElementById("forgetPasswordDiv");
	forgetPasswordDiv.style.display = "flex";
}


function passwordChange() {
	console.log("hello");
	let profileNumber = document.getElementById("profileNumber").value;
	let newPassword = document.getElementById("newPassword").value;
	let confirmpassword = document.getElementById("confirmpassword").value;
	let updateObj = [];
	xht.onreadystatechange = function() {
		if (xht.readyState == 4 && xht.status == 200) {
			updateObj.profileNumber = profileNumber;
			updateObj.newPassword = newPassword;
			updateObj.confirmpassword = confirmpassword;
			let updateSucc = JSON.parse(xht.responseText);
			if (updateSucc.Statuscode == 200 && updateSucc.Message == "Success") {
				alert("Succesfully Changed");
				let log = document.getElementById("log");
				log.style.display = "flex";
				let forgetPasswordDiv = document.getElementById("forgetPasswordDiv");
				forgetPasswordDiv.style.display = "none";
			}

		}
	}
	xht.open("POST", "http://localhost:8080/Cricbuzz/ForgetPassword");
	xht.setRequestHeader("Content-Type", "application/json");
	xht.send(JSON.stringify(updateObj));
}

let team1, team2, matchNo;

function teamreg() {
	addform.style.display = "none";
	addform2.style.display = "none";
	addform1.style.display = "none";
	addform3.style.display = "none";
	addform4.style.display = "none";
	addform5.style.display = "flex";
	addform7.style.display = "none";
	matchStart.style.display = "flex";
	toss.style.display = "none";
	usa.style.display = "flex";
	h.style.display = "none";
	t.style.display = "none";
	addform6.style.display = "none";
	xht.onreadystatechange = function() {
		if (xht.readyState == 4 && xht.status == 200) {
			team1 = document.getElementById("team1");
			team2 = document.getElementById("team2");
			matchNo = document.getElementById("matchNo");
			let jsonobj = JSON.parse(xht.responseText);
			console.log(jsonobj);
			if (team1.childElementCount == 0) {
				for (let j = 0; j < jsonobj.length; j++) {
					if (jsonobj[j].teamName != undefined) {
						let options = document.createElement("option");
						options.value = jsonobj[j].teamName;
						options.text = jsonobj[j].teamName;
						team1.add(options);
					}
				}
			}
			if (team2.childElementCount == 0) {
				for (let k = 0; k < jsonobj.length; k++) {
					if (jsonobj[k].teamName != undefined) {
						let option2 = document.createElement("option");
						option2.value = jsonobj[k].teamName;
						option2.text = jsonobj[k].teamName;
						team2.add(option2);
					}
				}
			}
			if (matchNo.childElementCount == 0) {
				for (let k = 0; k < jsonobj.length; k++) {
					if (jsonobj[k].matchName != undefined) {
						let option3 = document.createElement("option");
						option3.value = jsonobj[k].matchName;
						option3.text = jsonobj[k].matchName;
						matchNo.add(option3);
					}
				}
			}
		}
	}

	xht.open("POST", "http://localhost:8080/Cricbuzz/ShowteamServlet");
	xht.setRequestHeader("Content-Type", "application/json");
	xht.send();
}

function mydetails(PlayerDetails) {
	let plArr = (PlayerDetails.getAttribute("name")).split(",");
	pl.style.display = "none";
	pldetails.style.display = "flex";

	detName.innerText = plArr[0];
	detPhone.innerText = plArr[1];
	detState.innerText = plArr[2];
	detbirth.innerText = plArr[3];


	detName.onmouseover = function() {
		detName.innerText = "Name";
		detName.style.color = "black"
	}
	detName.onmouseout = function() {
		detName.style.color = "white";
		detName.innerText = '';
		detName.innerText = plArr[0];
	}
	detPhone.onmouseover = function() {
		detPhone.innerText = "Phone Number";
		detPhone.style.color = "black"
	}
	detPhone.onmouseout = function() {
		detPhone.style.color = "white";
		detPhone.innerText = '';
		detPhone.innerText = plArr[1];
	}
	detState.onmouseover = function() {
		detState.innerText = "State";
		detState.style.color = "black"
	}
	detState.onmouseout = function() {
		detState.style.color = "white";
		detState.innerText = '';
		detState.innerText = plArr[2];
	}
	detbirth.onmouseover = function() {
		detbirth.innerText = "DOB";
		detbirth.style.color = "black"
	}
	detbirth.onmouseout = function() {
		detbirth.style.color = "white";
		detbirth.innerText = '';
		detbirth.innerText = plArr[3];
	}

}
let team1value, team2value, matchidvalue, overs, sendObjTeamINMatch;

function matchStarted() {
	team1value = document.getElementById("team1").value;
	team2value = document.getElementById("team2").value;
	matchidvalue = document.getElementById("matchNo").value;
	overs = document.getElementById("overs").value;
	if (team1value != team2value && overs != "overs") {
		matchStart.style.display = "none";
		toss.style.display = "flex";
	} else {
		alert("Please choose different teams");
	}

	let fteamname = document.getElementById("fteamname");
	let steamname = document.getElementById("steamname");

	fteamname.innerText = team1value;
	steamname.innerText = team2value;

	sendObjTeamINMatch = matchidvalue + "," + overs;

}

function logout() {
	let sessionUser = sendString;
	console.log(sessionUser + "a");
	console.log("logout");
	document.cookie = "PHONE=";
	document.cookie = "SESSIONID=";
	xht.onreadystatechange = function() {
		if (xht.readyState == 4 && xht.status == 200) {
			let jsonObj3 = JSON.parse(xht.responseText);
			if (jsonObj3.statuscode == 200 && jsonObj3.Message == "Logout") {
				cookieCheck();
			}
		}

	}
	xht.open("POST", "http://localhost:8080/Cricbuzz/LogoutServlet");
	xht.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xht.send("sessionUser=" + sessionUser);
}

function yourDetails() {
	addform.style.display = "flex";
	addform1.style.display = "none";
	pldetails.style.display = "flex";
	addform2.style.display = "none";
	addform3.style.display = "none";
	xht.onreadystatechange = function() {
		if (xht.readyState == 4 && xht.status == 200) {
			console.log(xht.responseText);
			plObj = JSON.parse(xht.responseText);
			console.log(plObj);
			for (i = 0; i < plObj.length; i++) {
				if (plObj[i].PlNo == sendString) {
					plname = plObj[i].PlName;
					plNo = plObj[i].PlNo;
					plState = plObj[i].PLState;
					plDob = plObj[i].PLDob;
					plrole = plObj[i].PlRole;
				}
			}
			detName.innerText = plname;
			detPhone.innerText = plNo;
			detState.innerText = plState;
			detbirth.innerText = plDob;

			detName.onmouseover = function() {
				detName.innerText = "Name";
				detName.style.color = "black"
			}
			detName.onmouseout = function() {
				detName.style.color = "white";
				detName.innerText = '';
				detName.innerText = plname;
			}
			detPhone.onmouseover = function() {
				detPhone.innerText = "Phone Number";
				detPhone.style.color = "black"
			}
			detPhone.onmouseout = function() {
				detPhone.style.color = "white";
				detPhone.innerText = '';
				detPhone.innerText = plNo;
			}
			detState.onmouseover = function() {
				detState.innerText = "State";
				detState.style.color = "black"
			}
			detState.onmouseout = function() {
				detState.style.color = "white";
				detState.innerText = '';
				detState.innerText = plState;
			}
			detbirth.onmouseover = function() {
				detbirth.innerText = "DOB";
				detbirth.style.color = "black"
			}
			detbirth.onmouseout = function() {
				detbirth.style.color = "white";
				detbirth.innerText = '';
				detbirth.innerText = plDob;
			}
		}
	}


	xht.open("GET", "http://localhost:8080/Cricbuzz/ShowServlet");
	xht.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xht.send();
}
let total1 = 0;
let total2 = 0;
let kamesh = 0;
let teamsend = "";

function callThetoss() {
	k = 1;
	console.log(sendObjTeamINMatch);
	let arrSendTeam = sendObjTeamINMatch.split(",");
	console.log(arrSendTeam);
	let opinionfteam = document.getElementById("opinionfteam").value;
	let opinionsteam = document.getElementById("opinionsteam").value;
	let team1 = "";
	let team2 = "";
	if (opinionfteam != opinionsteam) {
		usa.style.display = "none";
		var numberofChoosen = Math.floor(Math.random() * 2);
		var batbowls = ["BAT", "BOWL"];
		var batbowl = batbowls[Math.floor(Math.random() * batbowls.length)]
		if (numberofChoosen == 0) {
			h.style.display = "flex";
		} else {
			t.style.display = "flex";
		}
		if (numberofChoosen == 0 && opinionfteam == "HEADS") {
			chosen.innerText = document.getElementById("fteamname").innerText + " have won the toss and " + batbowl + " first.";
		} else if (numberofChoosen == 0 && opinionsteam == "HEADS") {
			chosen.innerText = document.getElementById("steamname").innerText + " have won the toss and " + batbowl + " first.";
		}
		if (numberofChoosen == 1 && opinionfteam == "TAILS") {
			chosen.innerText = document.getElementById("fteamname").innerText + " have won the toss and " + batbowl + " first.";
		} else if (numberofChoosen == 1 && opinionsteam == "TAILS") {
			chosen.innerText = document.getElementById("steamname").innerText + " have won the toss and " + batbowl + " first.";
		}

	} else {
		alert("Wait for opponent");
	}

	if (chosen.innerText == document.getElementById("fteamname").innerText + " have won the toss and BAT first.") {
		team1 = document.getElementById("fteamname").innerText;
		team2 = document.getElementById("steamname").innerText;
	} else if (chosen.innerText == document.getElementById("fteamname").innerText + " have won the toss and BOWL first.") {
		team1 = document.getElementById("steamname").innerText;
		team2 = document.getElementById("fteamname").innerText;
	} else if (chosen.innerText == document.getElementById("steamname").innerText + " have won the toss and BOWL first.") {
		team1 = document.getElementById("fteamname").innerText;
		team2 = document.getElementById("steamname").innerText;
	} else if (chosen.innerText == document.getElementById("steamname").innerText + " have won the toss and BAT first.") {
		team1 = document.getElementById("steamname").innerText;
		team2 = document.getElementById("fteamname").innerText;
	}
	xht.onreadystatechange = function() {
		if (xht.readyState == 4 && xht.status == 200) {
			let jsonP = JSON.parse(xht.responseText);
			console.log(jsonP);
			for (let i = 0; i < jsonP.length; i++) {
				if (i < overs) {
					let playerwithscore = document.createElement("div");
					team1playerscore.appendChild(playerwithscore).setAttribute("id", "playerwithscore" + i);
					playerwithscore.setAttribute("class", "playerwithscore");
					let playerNames = document.createElement("div");
					playerwithscore.appendChild(playerNames).setAttribute("id", "playerNames" + i);
					playerNames.setAttribute("class", "playerNames");
					playerNames.innerText = jsonP[i].playerName;
					let scoreOfplayer = document.createElement("div");
					playerwithscore.appendChild(scoreOfplayer).setAttribute("id", "scoreOfplayer" + i);
					scoreOfplayer.setAttribute("class", "scoreOfplayer");
					scoreOfplayer.innerText = jsonP[i].playerScore;
					total1 += parseInt(jsonP[i].playerScore);
				} else {
					let playerwithscore = document.createElement("div");
					team2playerscore.appendChild(playerwithscore).setAttribute("id", "playerwithscore" + i);
					playerwithscore.setAttribute("class", "playerwithscore");
					let playerNames = document.createElement("div");
					playerwithscore.appendChild(playerNames).setAttribute("id", "playerNames" + i);
					playerNames.setAttribute("class", "playerNames");
					playerNames.innerText = jsonP[i].playerName;
					let scoreOfplayer = document.createElement("div");
					playerwithscore.appendChild(scoreOfplayer).setAttribute("id", "scoreOfplayer" + i);
					scoreOfplayer.setAttribute("class", "scoreOfplayer");
					scoreOfplayer.innerText = jsonP[i].playerScore;
					total2 += parseInt(jsonP[i].playerScore);
				}
			}
			console.log(total1 + "," + total2);
			team1NameForResult.innerText = team1value;
			team2NameForResult.innerText = team2value;
			team1score.innerText = total1;
			team2score.innerText = total2;
		}
		team1value.value = "";
		team2value.value = "";
		matchidvalue = "";
		overs.value = "";
	}
	let tossWinner = (chosen.innerText).indexOf("have");
	let sendteamObj = {};
	sendteamObj.team1 = team1;
	sendteamObj.team2 = team1;
	sendteamObj.matchid = arrSendTeam[0];
	sendteamObj.toss = (chosen.innerText).substring(0, tossWinner - 1);
	sendteamObj.overs = arrSendTeam[1];
	console.log(sendteamObj);
	xht.open("POST", "http://localhost:8080/Cricbuzz/ResultServlet");
	xht.setRequestHeader("Content-Type", "application/json");
	xht.send(JSON.stringify(sendteamObj));
	teamsend += sendteamObj.team1 + "," + sendteamObj.team2;
}

function Matchresult() {
	let teamsendArr = teamsend.split(",");
	if (k == 0) {
		alert("No Matches")
	} else {
		addform.style.display = "none";
		addform2.style.display = "none";
		addform1.style.display = "none";
		addform3.style.display = "none";
		addform4.style.display = "none";
		addform5.style.display = "none";
		addform6.style.display = "flex";
		addform7.style.display = "none";
		if (total1 > total2) {
			alert("Winner" + team1value);
		} else {
			alert("Winner" + team2value)
		}
	}
}

function searchThePlayer() {
	let searchpannuvom = document.querySelectorAll(".namesvekka");
	console.log(searchpannuvom);
	let search = document.getElementById("search").value;
	console.log(search);
	for (i = 0; i < searchpannuvom.length; i++) {
		if (((searchpannuvom[i].innerText).toLowerCase()).includes(search.toLowerCase())) {
			searchpannuvom[i].style.display = "flex";
		} else {
			let getvaluesss = document.getElementById("checkboxeses" + i);
			if (!(getvaluesss.checked)) {
				searchpannuvom[i].style.display = "none";
			}
		}
	}
}

function searchThePlayer2() {
	let searchpannuvom2 = document.getElementById("pl").childNodes;
	console.log(searchpannuvom2);
	let search2 = document.getElementById("search2").value;
	console.log(search2);
	for (i = 0; i < searchpannuvom2.length; i++) {
		if (((searchpannuvom2[i].innerText).toLowerCase()).includes(search2.toLowerCase())) {
			searchpannuvom2[i].style.display = "flex";
		} else {
			searchpannuvom2[i].style.display = "none";
		}
	}
}

function updatetheDetails() {
	addform1.style.display = "none";
	addform.style.display = "none";
	addform2.style.display = "flex";
	addform3.style.display = "none";
	updates.style.backgroundColor = "#5B6176";
	profileAdmin.style.background = "none";
	match.style.background = "none";
}

function updatetheDetails2() {
	plNameUpdate = document.getElementById("plNameUpdate").value;
	plstateUpdate = document.getElementById("plstateUpdate").value;
	pldateUpdate = document.getElementById("pldateUpdate").value;
	xht.onreadystatechange = function() {
		if (xht.readyState == 4 && xht.status == 200) {
			console.log(xht.responseText);
			plObj = JSON.parse(xht.responseText);
			console.log(plObj);
			if (plObj.StatusCode == 200 && plObj.Message == "SuccessfullyUpdated") {
				alert(plObj.Message);
				document.getElementById("plNameUpdate").value = "";
				document.getElementById("plstateUpdate").value = "";
				document.getElementById("pldateUpdate").value = "";
			} else {
				alert(plObj.Message);
			}
		}
	}
	let updateObj = {};
	updateObj.no = sendString;
	updateObj.name = plNameUpdate;
	updateObj.state = plstateUpdate;
	updateObj.date = pldateUpdate;
	xht.open("POST", "http://localhost:8080/Cricbuzz/UpdatetheDetails");
	xht.setRequestHeader("Content-Type", "application/json");
	xht.send(JSON.stringify(updateObj));
}

function stats() {
	addform1.style.display = "none";
	addform.style.display = "none";
	addform2.style.display = "none";
	addform3.style.display = "flex";

	xht.onreadystatechange = function() {
		if (xht.readyState == 4 && xht.status == 200) {
			let jsoonB = JSON.parse(xht.responseText);
			console.log(jsoonB);
			if (jsoonB.StatusCode == 400) {
				alert(jsoonB.Message);
			} else {
				runs.innerText = jsoonB.run;
				hs.innerText = jsoonB.hs;
				matchesNos.innerText = jsoonB.mat;
			}
		}
	}
	let nos = sendString;
	xht.open("POST", "http://localhost:8080/Cricbuzz/StatsServlet");
	xht.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xht.send("nos=" + nos);
}

function Teamremove() {
	addform.style.display = "none";
	addform2.style.display = "none";
	addform1.style.display = "none";
	addform3.style.display = "none";
	addform4.style.display = "none";
	addform5.style.display = "none";
	addform6.style.display = "none";
	addform7.style.display = "flex";

	xht.onreadystatechange = function() {
		if (xht.readyState == 4 && xht.status == 200) {
			let jsonobj = JSON.parse(xht.responseText);
			console.log(jsonobj);
			if (teamName.childElementCount == 0) {
				for (let j = 0; j < jsonobj.length; j++) {
					if (jsonobj[j].teamName != undefined) {
						if (j == 0) {
							let options = document.createElement("option");
							options.value = "TeamNames";
							options.text = "TeamNames";
							teamName.add(options);
						}
						let options = document.createElement("option");
						options.value = jsonobj[j].teamName;
						options.text = jsonobj[j].teamName;
						teamName.add(options);
					}
				}
			}
		}
	}
	xht.open("POST", "http://localhost:8080/Cricbuzz/ShowteamServlet");
	xht.setRequestHeader("Content-Type", "application/json");
	xht.send();
}

function TeamPlayersGet() {
	while (playerNameForTeam.hasChildNodes()) {
		playerNameForTeam.removeChild;
	}
	teamName = document.getElementById("teamName").value;
	console.log(teamName);

	if (teamName != "TeamNames") {
		xht.onreadystatechange = function() {
			if (xht.readyState == 4 && xht.status == 200) {
				let jsonO = JSON.parse(xht.responseText);
				console.log(jsonO);
				if (jsonO.StatusCode == 400) {
					alert("No teams");
				} else {
					let arrayOfPlayers = (jsonO.TeamPlayers).split(",");
					for (let i = 0; i < arrayOfPlayers.length; i++) {
						let namesForPlayer = document.createElement("div");
						playerNameForTeam.appendChild(namesForPlayer).setAttribute("id", "namesForPlayer" + i);
						namesForPlayer.setAttribute("class", "namesForPlayer");
						let checkboxeses2 = document.createElement("input");
						namesForPlayer.appendChild(checkboxeses2).setAttribute("type", "checkbox");
						checkboxeses2.setAttribute("id", "checkboxeses2" + (i));
						checkboxeses2.setAttribute("value", arrayOfPlayers[i]);
						checkboxeses2.setAttribute("name", arrayOfPlayers[i]);
						namesForPlayer.append(arrayOfPlayers[i]);
					}
				}
			}
		}
	} else {
		alert("Choose the team name");
	}
	xht.open("POST", "http://localhost:8080/Cricbuzz/TeamPlayerRemove");
	xht.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xht.send("teamname=" + teamName);
}

function sendTheRemovedPlayer() {

	let pnft = playerNameForTeam.childNodes.length;
	let getpnft;
	let getpnftsend = "";

	for (let i = 0; i < pnft; i++) {
		getpnft = document.getElementById("checkboxeses2" + i);
		if (!getpnft.checked) {
			getpnftsend += document.getElementById("checkboxeses2" + i).getAttribute("name");
		}
	}
}