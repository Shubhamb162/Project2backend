package com.test.project2backend.dao;

import java.util.List;

import com.test.project2backend.model.Blog;

public interface BlogDao {

	public boolean addBlog(Blog blog);

	public boolean deleteBlog(Blog blog);

	public Blog getBlog(Integer id);

	public boolean updateBlog(Blog blog);

	public List<Blog> getALLBlogs();

	public Boolean approveBlogs(Blog blog);

}
