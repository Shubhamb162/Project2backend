package com.test.project2backend;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.project2backend.dao.BlogDao;

import com.test.project2backend.model.Blog;

public class BlogTesting {

	// we have to declare reference variables here to access it in any method
	private static AnnotationConfigApplicationContext context;

	private static BlogDao blogDao;
	private static Blog blog;

	@BeforeClass
	public static void init() {
		// making object of AnnotationConfigApplicationContext
		context = new AnnotationConfigApplicationContext();
		// scanning the whole project for making bean objects
		context.scan("com.test.project2backend");
		// refresh the Spring Container
		context.refresh();
		// getting the beans of blogDao type
		blogDao = (BlogDao) context.getBean("blogDao");
		blog = new Blog();

	}

	@Test
	public void addBlogTest() {
		blog.setBlog_Name("First Blog");
		blog.setBlog_Content("This is my First Blog");
		blog.setBlog_Date(new java.util.Date());
		blog.setBlogger_Name("Anuj");
		Assert.assertEquals("Data Entered Ureka", true, blogDao.addBlog(blog));
	}

	@Test
	public void deleteBlogTest() {
		blog.setBlog_Id(12);
		Assert.assertEquals("Data Entered Ureka", true, blogDao.deleteBlog(blog));
	}

	@Test
	public void getBlogTest() {
		blog = blogDao.getBlog(10);
		Assert.assertNotNull(blog);
		System.out.println(blog.getBlog_Name());
	}

	@Test
	public void updateBlogTest() {
		blog = blogDao.getBlog(10);
		blog.setBlogger_Name("Aman");
		Assert.assertEquals("Data Entered Ureka", true, blogDao.updateBlog(blog));
	}

	@Test
	public void getALLBlogTest() {
		List<Blog> blogList = blogDao.getALLBlogs();
		Iterator<Blog> itr = blogList.iterator();

		Assert.assertEquals(true, itr.hasNext());
		// assertThat(blogList, not(IsEmptyCollection.empty()));
		// Assert.assertEquals("Blog List", true, !(blogList.isEmpty()));
	}

}
