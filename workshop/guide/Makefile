.PHONY: clean images

BOOK=book
SOURCE_DIRECTORY=src
SOURCES=$(shell find ${SOURCE_DIRECTORY} -name '*.md')

${BOOK}: ${SOURCES} images 
	mdbook build

clean:
	mdbook clean
	rm -f ${IMAGE_TARGETS}