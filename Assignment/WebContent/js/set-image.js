function readURL(input) {
  if (input.files && input.files[0]) {
    var reader = new FileReader();
    
    reader.onload = function(e) {
      $('#blah').attr('src', e.target.result);
    }
    
    reader.readAsDataURL(input.files[0]); // convert to base64 string
  }
}

$("#imgInp").change(function() {
  readURL(this);
});

function PreviewImage() {
        var oFReader = new FileReader();
 		
		oFReader.readAsDataURL(document.getElementById("imageId").files[0]);

        oFReader.onload = function (oFREvent) {
            document.getElementById("upImgId").src = oFREvent.target.result;
        };
    };