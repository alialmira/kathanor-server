package net.springbootserver.kathanorbackend.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.io.File;
import java.io.IOException;

import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import net.springbootserver.kathanorbackend.models.File201;
import net.springbootserver.kathanorbackend.repositories.File201Repository;
import net.springbootserver.kathanorbackend.services.File201Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/kathanor-api/201file")
public class File201Controllers {
  private static final Logger logger = LoggerFactory.getLogger(
    File201Controllers.class
  );

  @Autowired
  private File201Service file201Service;

  @ApiOperation(value = "Upload 201 file", nickname = "upload201File")
  @PostMapping
  public String addFile(
    @RequestParam("uploadedBy") String uploadedBy,
    @RequestParam("dateUploaded") String dateUploaded,
    @RequestParam("employeeId") String employeeId,
    @RequestParam("docType") String docType,
    @RequestPart("content") @ApiParam(
      value = "content",
      required = true
    ) MultipartFile file
  )
    throws IOException {
    String id = file201Service.addFile(uploadedBy, dateUploaded, employeeId, docType, file);
    return id;
  }

  @ApiOperation(value = "Get all 201 File", nickname = "getAll201Files")
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<File201> GetAll() {
    List<File201> files = this.file201Service.getAllFiles();
    files.forEach((File201 file) -> {
      file.setContent(null);
    });
    return files;
  }

  @ApiOperation(value = "Get all 201 files of employee", nickname = "get201Files")
  @RequestMapping(value = "/{empId:.+}", method = RequestMethod.GET)
  public List<File201> GetAll(@PathVariable("empId") String empId) {
        List<File201> files = this.file201Service.findAllFiles(empId);
        files.forEach((File201 file) -> {
          file.setContent(null);
        });
        return files;
    }

  @ApiOperation(value = "Download file by file name", nickname = "DownloadFile")
  @GetMapping("/downloadFile/{id:.+}")
  public ResponseEntity<Resource> downloadFile(
    @PathVariable String id,
    HttpServletRequest request
  ) {
    // Load file as Resource
    File201 file = file201Service.getFile(id);

    // Try to determine file's content type
    String contentType = null;

    contentType = request.getServletContext().getMimeType(file.getMimeType());

    // Fallback to the default content type if type could not be determined
    if (contentType == null) {
      contentType = "application/octet-stream";
    }

    Resource resource = new ByteArrayResource(
      file.getContent().getData()
    );

    return ResponseEntity
      .ok()
      .contentType(MediaType.parseMediaType(contentType))
      .header(
        HttpHeaders.CONTENT_DISPOSITION,
        "attachment; filename=\"" + file.getFilename() + "\""
      )
      .body(resource);
  }
}
