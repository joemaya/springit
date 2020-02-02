package com.example.demo.controller;

import com.example.demo.domain.lombok.Comment;
import com.example.demo.domain.lombok.Link;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.LinkRepository;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.Optional;


@Controller
public class LinkController {

//    @GetMapping("/foo")
//    public String foo(Model model) {
//        model.addAttribute("pageTitle", "This page is FOOOO!!");
//        return "foo";
//    }

    private static final Logger logger = LoggerFactory.getLogger(LinkController.class);
;
    private LinkRepository linkRepository;
    private CommentRepository commentRepository;

    public LinkController(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("links", linkRepository.findAll());
        return "link/list";
    }

    @GetMapping("/link/{id}")
    public String read(@PathVariable Long id, Model model) {
        model.addAttribute("link", linkRepository.getOne(id));
        Optional<Link> link = linkRepository.findById(id);
        if(link.isPresent()) {
            Link mainLink = link.get();
            Comment comment = new Comment();
            comment.setLink(mainLink);
            model.addAttribute("comment", comment);
            model.addAttribute("link", mainLink);
            model.addAttribute("success", model.containsAttribute("success"));
        }else {
            return "redirect:/";
        }

        return "link/view";
    }


    @GetMapping("/link/submit")
    public String newLinkForm(Model model) {
        model.addAttribute("link", new Link());
        return "link/submit";
    }

    @PostMapping("/link/submit")
    public String createLink(@Valid Link link, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            // handle the errores
            logger.info("Errors found while adding the link");
            model.addAttribute("link", link);
            return "link/submit";
        } else {
            // save the link
            linkRepository.save(link);
            logger.info("new link was saved successfully");

            redirectAttributes
                    .addAttribute("id", link.getId())
                    .addFlashAttribute("success", true)            ;

        }
        return "redirect:/link/{id}";
    }

    @Secured({"ROLE_USER"})
    @PostMapping("/link/comments")
    public String addComment(@Valid Comment comment, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            // handle the errores
            logger.info("Errors found while adding the comment");

        } else {
            // save the comment
            commentRepository.save(comment);
            logger.info("new comment was saved successfully");
        }
        return "redirect:/link/" + comment.getLink().getId();
    }


}
