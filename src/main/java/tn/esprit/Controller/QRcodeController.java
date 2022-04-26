package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.QRcodeGenerator;
import tn.esprit.Entities.Event;
import tn.esprit.Services.IDonService;
import tn.esprit.Services.IEventService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/qr")
public class QRcodeController {
	
private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRcodeImage";
@Autowired
IEventService eventInterface;
Event e = new Event();

String QRCode=e.getLabelle();

	
    @GetMapping(value = "/genrateAndDownloadQRCode/{idDon-id}/{width}/{height}")
		public void download(
				@PathVariable("idDon-id") Long  idEvent,
				@PathVariable("width") Integer width,
				@PathVariable("height") Integer height)
			    throws Exception {
    				String a =eventInterface.retrieveEvent(idEvent).getLabelle();
			        QRcodeGenerator.generateQRCodeImage(a.toString(), width, height, QR_CODE_IMAGE_PATH +"/"+a+".png");
			      // e.setImage(a.png);
			        
			    }

    @GetMapping(value = "/genrateQRCode/{codeText}/{width}/{height}")
   	public ResponseEntity<byte[]> generateQRCode(
   			@PathVariable("codeText") String codeText,
   			@PathVariable("width") Integer width,
   			@PathVariable("height") Integer height)
   		    throws Exception {
   		        return ResponseEntity.status(HttpStatus.OK).body(QRcodeGenerator.getQRCodeImage(codeText, width, height));
   		    }
}
