/**
 * 
 */

function openMenu() {
    var x = document.getElementById("navbarDropMenu");
    var y = document.getElementById("menuOverlay");
    var z = document.getElementById("menuButton");
    alert(z.className+'==>'+x.className+'-->'+y.className)
    if (z.className.indexOf("s-text-gray") == -1) {
        z.className += " s-text-gray";
    } else { 
        z.className = z.className.replace(" s-text-gray", "");
    }
    if (z.className.indexOf("s-gray") == -1) {
        z.className += " s-gray";
    } else { 
        z.className = z.className.replace(" s-gray", "");
    }
    if (x.className.indexOf("s-show") == -1) {
        x.className += " s-show";
    } else { 
        x.className = x.className.replace(" s-show", "");
    }
    if (y.className.indexOf("s-show") == -1) {
        y.className += " s-show";
    } else { 
        y.className = y.className.replace(" s-show", "");
    }
    alert('End===>'+z.className+'==>'+x.className+'-->'+y.className)
}
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == document.getElementById("saveModal")) {
        hideAndResetModal();
    }
    if (event.target == document.getElementById("driveSaveModal")) {
        resetDriveSaveModal();
    }
    if (event.target == document.getElementById("driveLoadModal")) {
        resetDriveLoadModal();
    }
    if (event.target == document.getElementById("menuOverlay")) {
        openMenu();
    }
    
}