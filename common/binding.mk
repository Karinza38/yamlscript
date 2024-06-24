include $(COMMON)/docker.mk

test:: $(LIBYAMLSCRIPT_SO_FQNP)

$(LIBYAMLSCRIPT_SO_FQNP): $(ROOT)/libyamlscript
	$(MAKE) -C $< build

ReadMe.md: $(COMMON)/readme.md $(wildcard doc/*.md) $(ROOT)/util/markys
	markys $< > $@
