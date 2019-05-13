package com.example.demo.api;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.IssueDetailDto;
import com.example.demo.Dto.IssueDto;
import com.example.demo.Dto.IssueUpdateDto;
import com.example.demo.Dto.ProjectDto;
import com.example.demo.entity.IssueStatus;
import com.example.demo.service.IssueService;
import com.example.demo.service.Imp.IssueServiceImp;
import com.example.demo.util.ApiPaths;
import com.example.demo.util.TPage;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Api(value = ApiPaths.IssueCtrl.CTRL,description ="Issue APIs")
@CrossOrigin
public class IssueController {

	private final IssueServiceImp issueService;
	
	
	public IssueController(IssueServiceImp issueService) {
		super();
		this.issueService = issueService;
	}

    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation", response = IssueDto.class)
    public ResponseEntity<TPage<IssueDto>> getAllByPagination(Pageable pageable) {
        TPage<IssueDto> data = issueService.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ApiOperation(notes="Get By Id operation for Issue",value="Get By Id operation for Issue",response=IssueDto.class)
	public ResponseEntity<IssueDto> getById(@PathVariable(name="id",required=true) Long id) {
		IssueDto IssueDto=issueService.getById(id);
		return ResponseEntity.ok(IssueDto);
	}
	
	//localhost:8182/api/issue/detail/1000
	//http://localhost:8182/api/issue/detail/1001
    @GetMapping("/detail/{id}")
    @ApiOperation(value = "Get By Id Operation", response = IssueDto.class)
    public ResponseEntity<IssueDetailDto> getByIdWithDetails(@PathVariable(value = "id", required = true) Long id) {
        IssueDetailDto detailDto = issueService.getByIdWithDetails(id);
        return ResponseEntity.ok(detailDto);
    }
    
	@PostMapping
	@ApiOperation(value="Create operation for Issue",response=IssueDto.class)
	public ResponseEntity<IssueDto> createissueDto(@Valid @RequestBody IssueDto issueDto){
		return ResponseEntity.ok(issueService.save(issueDto));
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value="Update for Issue",response=IssueDto.class)
	//@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<IssueDetailDto> updateissueDto(@PathVariable(name="id",required=true) Long id,@Valid @RequestBody IssueUpdateDto issue){
		return ResponseEntity.ok(issueService.update(id, issue));
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value="Delete operation for Issue",response=Boolean.class)
	public ResponseEntity<Boolean> deleteissueDto(@PathVariable(name="id", required=true) Long id) {
		
		return ResponseEntity.ok(issueService.delete(id));
	}
	
//    @GetMapping()
//    @ApiOperation(value = "Get All IssueStatus Operation", response = IssueDto.class , responseContainer = "List")
//    public ResponseEntity<List<IssueDto>> getAll() {
//        List<IssueDto> data = issueService.getAll();
//        return ResponseEntity.ok(data);
//    }
	
    @GetMapping("/statuses")
    @ApiOperation(value = "Get All IssueStatus Operation", response = String.class , responseContainer = "List")
    public ResponseEntity<List<IssueStatus>> getAll() {
        return ResponseEntity.ok(Arrays.asList(IssueStatus.values()));
    }
}
